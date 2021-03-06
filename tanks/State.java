package tanks;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class State{
    protected StateManager stateManager;
    protected Scene scene;
    protected Controller controller;

    public State(StateManager stateManager, String fxmlFileName) {
        this.stateManager = stateManager;

        FXMLLoader fxmlLoader = createFXMLLoader(fxmlFileName);

        try {
            fxmlLoader.load();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        try {
            controller = fxmlLoader.getController();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        controller.setAssociatedState(this);

        Parent root = controller.getRoot();
        scene = new Scene(root);
    }

    private FXMLLoader createFXMLLoader(String fxmlFileName) {
        URL location = getClass().getResource(fxmlFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        return fxmlLoader;
    }

    public Scene getScene() {
        return scene;
    }
}
