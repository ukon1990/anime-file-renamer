package net.sample.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import net.sample.models.ErrorMessage;

public class ErrorHandler {
    public static ObservableList<ErrorMessage> errorEvents = FXCollections.observableArrayList();

    public static void displayErrorMessage(String title, String message, Exception exception) {
        ErrorMessage error = new ErrorMessage(title, message, exception);
        errorEvents.add(error);
        openErrorDialog(error);
    }

    private static void openErrorDialog(ErrorMessage errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(errorMessage.getTitle());
        Label label = new Label("Stacktrace:");

        TextArea textArea = new TextArea(errorMessage.getStackTrace());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
