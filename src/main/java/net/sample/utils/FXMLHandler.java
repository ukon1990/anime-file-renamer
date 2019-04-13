package net.sample.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class FXMLHandler {
    public static URL getFXML(String path) {
        try {
            return Paths.get("./src/main/resources/fxml/" + path + ".fxml")
                    .toUri()
                    .toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setScene(String scenePath, Control control) {
        try {
            FXMLLoader loader = new FXMLLoader(getFXML(scenePath));
            Stage stage = (Stage) control.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setWidth(Stage stage, double width) {
        stage.setWidth(width);
    }
}
