# Base JavaFX project with Java 11, JUnit5 and Maven
The default IntelliJ IDEA JAVAFX project was still designed for Java 8, unless I am mistaken.
So here you have a boilerplate project for using Java 11 with JavaFX, JUnit5 and Maven.

## Why this template/sample project?
I don't really use JavaFX for work. But felt the need to try it out.
But as I wanted to use Java 11, I found it really bothersome to set up.
So here you have a boilerplate project, to avoid getting bothered with the setup, the next time.

## Setup
In IntelliJ IDEA do the following:

``
open the Maven menu -> Plugins -> exec -> right click exec:java -> Select create
``

``
Open run configurations -> and run the one in there
``

## Loading scenes and FXML files
I am not really sure if this is "good" practice or not.
All the fxml files are stored in ``resources/fxml``.
So in order to load them, you can use the method ``getFXML("pathToFile")``.

```java
public class Main extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getFXML("main"));
        // Or of the .fxml file is located in a sub directory.
        // Do keep in mind, that you don't need to add the .fxml extension.
        root = FXMLLoader.load(getFXML("user/profile"));
        
        // The rest of the code
    }
}
```


### Loading a scene from another
I've created the method ``FXMLHandler.setScene(String scenePath, Control control)`` for this.
You can use it like this:
```java
public class SampleController implements Initializable {
    @FXML
    private PasswordField passwordField;
    
    void loadScene() {
        // Just pass in some field from the fxml.
        setScene("main", passwordField);
    }
}
```