package net.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static net.sample.utils.FXMLHandler.getFXML;

/**
 * Det skal lages et Java-program til et vikarbyrå. Vikarbyråets oppgave er å formidle kontakt mellom
 * personer som ønsker seg et midlertidig engasjement og virksomheter som trenger vikarer.
 * Programmet som skal utvikles skal gjøre det lettere å få rett vikar til rett virksomhet.
 * <p>
 * <p>
 * Trenger altså 1 side for jobbsøkere/vikarer og en side for arbeidsgivere
 */
public class Main extends Application {
    static String initDir;

    public static void main(String[] args) {
        Main.initDir = System.getProperty("user.dir");
        System.out.println(initDir);
        if (args != null) {
            System.out.println(args);
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getFXML("main"));
        stage.setTitle("App name");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
