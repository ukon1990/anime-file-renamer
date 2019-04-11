package net.jonaskf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super temps");
        stage.setScene(new Scene(new Pane(), 800, 600));
        stage.show();
    }
}
