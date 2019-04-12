package net.jonaskf.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import static net.jonaskf.utils.files.FileReader.openFilePicker;

public class MainController implements Initializable {
    @FXML
    private void openFileEvent(ActionEvent event) {
        openFilePicker();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
