package boxingchallenge.controller;

import boxingchallenge.content.auxiliary.Draftsman;
import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.HumanBoxer;
import boxingchallenge.content.fight.Action;
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
public class Fight implements Initializable {
    @FXML private AnchorPane anchor;
    @FXML private Label humanName, opponentName, round;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private Action fightAction;

    @Autowired
    private HumanBoxer boxer;

    @Autowired
    private Draftsman draftsman;

    private AIBoxer opponent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        opponent = draftsman.getSummoned();
        round.setText(String.valueOf("Runda: " + fightAction.getRoundCounter()));
        humanName.setText(boxer.getName());
        opponentName.setText(opponent.getName());
        fightAction.init();
    }

    public void backMainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) anchor.getScene().getWindow();
        stage.setScene(scene);
    }

    public AIBoxer getOpponent() {
        return opponent;
    }

    public AnchorPane getAnchor() {
        return anchor;
    }

    public Label getRound() {
        return round;
    }
}
