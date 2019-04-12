package net.jonaskf.utils.files;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static net.jonaskf.utils.ErrorHandler.displayErrorMessage;

public class FileReader {
    public static void openFilePicker() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("Java objekt filer", "*.png", "*.jpg", "*.jobj"));
        File selectedFile = fileChooser.showOpenDialog(null); // mainStage
        if (selectedFile != null) {
            handleFile(selectedFile);
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
        }else {
            System.out.println("Dunno");
        }
    }
}
