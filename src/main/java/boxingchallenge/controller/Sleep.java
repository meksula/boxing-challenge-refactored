package boxingchallenge.controller;

import boxingchallenge.content.auxiliary.AnimationTimer;
import boxingchallenge.content.characters.HumanBoxer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Sleep implements Initializable{
    @FXML private AnchorPane pane;
    @FXML private Label sleepTimeRest, gameDay;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private AnimationTimer timer;

    @Autowired
    private HumanBoxer boxer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timer.timerStart();
        gameDay.setText(String.valueOf(boxer.getQueue().getGameDay()));
    }

    public void timeToWakeUp() {
        pane.getStylesheets().clear();
        pane.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        pane.getStyleClass().add("dayBackground");
        boxer.getQueue().nextDay();
        boxer.getQueue().setMove(true);
    }

    public void backMainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(scene);
    }

    public Label getSleepTimeRest() {
        return sleepTimeRest;
    }
}
