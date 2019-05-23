package net.sample.utils;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.function.Function;

import static net.sample.utils.ErrorHandler.displayErrorMessage;

public class FileReader {
    public static void openFolderPicker(Function<String, Boolean> function) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Resource File");
        File selectedFile = directoryChooser.showDialog(null);
        if (selectedFile != null) {
            handleFile(selectedFile);
            function.apply(selectedFile.getPath());
        }
    }

    public static void openFilePicker(Function<String, Boolean> function) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("Java objekt filer", "*.png", "*.jpg", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(null); // mainStage
        if (selectedFile != null) {
            handleFile(selectedFile);
            function.apply(selectedFile.getPath());
        } else {
            displayErrorMessage("selectedFile != null", "", new Exception());
        }
    }

    private static void handleFile(File file) {
        System.out.println("Selected file" + file.getName());
        if (file != null && file.getName().indexOf(".csv") > -1) {
            System.out.println(".csv file");
        } else if (file != null && file.getName().indexOf(".jobj") > -1) {
            System.out.println(".jobj file");
        } else {
            System.out.println("Dunno");
        }
    }
}
