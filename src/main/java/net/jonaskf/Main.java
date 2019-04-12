package net.jonaskf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.jonaskf.utils.FXMLHandler;

import java.net.URL;
import java.nio.file.Paths;

import static net.jonaskf.utils.FXMLHandler.getFXML;

/**
 * Det skal lages et Java-program til et vikarbyrå. Vikarbyråets oppgave er å formidle kontakt mellom
 * personer som ønsker seg et midlertidig engasjement og virksomheter som trenger vikarer.
 * Programmet som skal utvikles skal gjøre det lettere å få rett vikar til rett virksomhet.
 * <p>
 * <p>
 * Trenger altså 1 side for jobbsøkere/vikarer og en side for arbeidsgivere
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getFXML("login"));
        stage.setTitle("Super temps");
        stage.setScene(new Scene(root, 431, 256));
        stage.show();
    }
}
