package net.sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sample.models.Episode;
import net.sample.models.FileToReplace;
import net.sample.models.Show;
import net.sample.utils.TVDBUtil;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;

import static net.sample.utils.FileReader.openFolderPicker;
import static net.sample.utils.Regex.getMatches;

public class MainController implements Initializable {
    private TVDBUtil tvdb = new TVDBUtil();
    private Show show;
    private List<FileToReplace> replaceList = new ArrayList<>();

    @FXML
    private Parent episodeTable;
    @FXML
    private TableController episodeTableController;
    @FXML
    private Parent fileTable;
    @FXML
    private TableController fileTableController;

    @FXML
    private TextField searchField;
    @FXML
    private TextField folderPathField;
    @FXML
    private TextField regexField;

    @FXML
    private Label nameLabel;
    @FXML
    private Label episodeLabel;
    @FXML
    private Label filesToCorrectLabel;

    @FXML
    private void search(ActionEvent event) {
        System.out.println("The value is: " + this.searchField.getText());
        Show show = tvdb.getShowData(this.searchField.getText());
        if (show != null) {
            episodeTableController.clear();
            nameLabel.setText(show.getTitle());
            episodeLabel.setText(show.getEpisodes().size() + "");
            show.getEpisodes()
                    .forEach(episodeTableController::add);
            this.show = show;
        }
    }

    @FXML
    private void getFilesInDirectory(ActionEvent event) {
        openFolderPicker(this::handleDirectorySelection);
    }

    @FXML
    private void renameFiles(ActionEvent event) {
        replaceList.forEach(this::renameFile);
    }

    @FXML
    private void reProcessFiles(ActionEvent event) {
        handleDirectorySelection(new File(folderPathField.getText()));
    }


    private boolean handleDirectorySelection(File folder) {
        File[] files = folder.listFiles();
        replaceList.clear();
        fileTableController.clear();


        folderPathField.setText(folder.getPath());

        if (searchField.getText() == null || searchField.getText().length() == 0) {
            searchField.setText(folder.getName());
            search(null);
        }

        if (files != null && this.show != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Matcher numberMatch = getMatches(
                            file.getName(),
                            regexField.getText());
                    if (numberMatch.find()) {
                        int index = Integer.parseInt(numberMatch.group(0).replaceAll(" ", ""));
                        addFileIfEpisodeMatchFound(file, index);
                    } else {
                        System.out.println("Number not found: " + file.getName());
                    }
                }
            }
            Collections.sort(replaceList, Comparator.comparingInt(FileToReplace::getNumber));
            replaceList.forEach(
                    fileTableController::add);
        }

        filesToCorrectLabel.setText(replaceList.size() + "");

        return true;
    }

    private void addFileIfEpisodeMatchFound(File file, int index) {
        if (this.show.getEpisodes().get(index) != null) {
            Episode episode = this.show.getEpisodes().get(index - 1);
            Matcher extensionMatch = getMatches(
                    file.getName(),
                    "(\\.[a-z]{1,5})");

            if (extensionMatch.find()) {
                FileToReplace ftr = new FileToReplace(
                        index,
                        file.getName(),
                        getNewName(episode, extensionMatch),
                        "Season " + episode.getSeason(),
                        file);

                replaceList.add(ftr);
            }
        }
    }

    private String getNewName(Episode episode, Matcher extensionMatch) {
        return nameLabel.getText() +
                " - s" + episode.getSeason() +
                "e" + getEpisodeString(episode) +
                extensionMatch.group(0);
    }

    private String getEpisodeString(Episode episode) {
        return episode.getEpisode() < 10 ? "0" + episode.getEpisode() : episode.getEpisode() + "";
    }

    private void renameFile(FileToReplace file) {
        String path = folderPathField.getText() + "/" +
                file.getSeasonFolder() + "/";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File newFile = new File(
                path +
                        file.getNewName());

        if (file.getFile().renameTo(newFile)) {
            System.out.println("Successfully renamed file at: " + newFile.getPath());
        } else {
            System.out.println("Could not rename");
        }
    }

    private void setEpisodeColumns() {
        episodeTableController.addColumn("Num", "episodeNumber", Integer.class);
        episodeTableController.addColumn("Season", "season", String.class);
        episodeTableController.addColumn("Episode", "episode", Integer.class);
        episodeTableController.addColumn("Title", "episodeName", String.class);
        episodeTableController.addColumn("Aired", "firstAired", Date.class);
    }

    private void setFileColumns() {
        fileTableController.addColumn("Number", "number", Integer.class);
        fileTableController.addColumn("Name", "currentName", String.class);
        fileTableController.addColumn("Folder", "seasonFolder", String.class);
        fileTableController.addColumn("New name", "newName", String.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEpisodeColumns();
        setFileColumns();
        regexField.setText("( [\\d]{1,})");
    }

}
