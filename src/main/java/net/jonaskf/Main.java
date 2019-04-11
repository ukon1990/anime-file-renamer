package net.jonaskf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Det skal lages et Java-program til et vikarbyrå. Vikarbyråets oppgave er å formidle kontakt mellom
     * personer som ønsker seg et midlertidig engasjement og virksomheter som trenger vikarer.
     * Programmet som skal utvikles skal gjøre det lettere å få rett vikar til rett virksomhet.
     * Registreringsdata:
     * @param args
     */
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
