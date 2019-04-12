package net.jonaskf.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static net.jonaskf.utils.ErrorHandler.displayErrorMessage;
import static net.jonaskf.utils.FXMLHandler.setScene;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginEvent(ActionEvent event) {
        if (this.usernameField.getText().length() == 0) {
            displayErrorMessage(
                    "Brukernavn mangler",
                    "Du har ikke skrevet inn ett brukernavn",
                    new Exception());
        } else {
            setScene("main", passwordField);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameField.setText("Brukernavn");

    }
}
