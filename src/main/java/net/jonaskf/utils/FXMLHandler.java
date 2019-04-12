package net.jonaskf.utils;

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
}
