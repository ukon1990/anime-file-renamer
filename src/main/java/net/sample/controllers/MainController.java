package net.sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sample.models.FileToReplace;
import net.sample.models.Show;
import net.sample.utils.TVDBUtil;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import static net.sample.utils.FileReader.openFolderPicker;

public class MainController implements Initializable {
    TVDBUtil tvdb = new TVDBUtil();

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
    private Label nameLabel;
    @FXML
    private Label episodeLabel;

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
        }
    }

    @FXML
    private void getFilesInDirectory(ActionEvent event) {
        openFolderPicker(this::handleDirectorySelection);
    }

    private boolean handleDirectorySelection(String s) {
        File folder = new File(s);
        File[] files = folder.listFiles();

        folderPathField.setText(s);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileTableController.add(
                            new FileToReplace(file.getName(),
                                    "TODO",
                                    "Season x"));
                }
            }
        }


        return true;
    }

    private void setEpisodeColumns() {
        episodeTableController.addColumn("Num", "episodeNumber", Integer.class);
        episodeTableController.addColumn("Season", "season", String.class);
        episodeTableController.addColumn("Episode", "episode", Integer.class);
        episodeTableController.addColumn("Title", "episodeName", String.class);
        episodeTableController.addColumn("Aired", "firstAired", Date.class);
    }

    private void setFileColumns() {
        fileTableController.addColumn("Name", "currentName", String.class);
        fileTableController.addColumn("New name", "newName", String.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchField.setText("One piece");

        setEpisodeColumns();
        setFileColumns();
    }

}
