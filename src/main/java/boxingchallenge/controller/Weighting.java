package boxingchallenge.controller;

import boxingchallenge.content.characters.HumanBoxer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class Weighting implements Initializable {
    @FXML
    private Label nameHuman, nationHuman, weightHuman, heightHuman, balanceHuman, nameOpponent,
            nationOpponent, weightOpponent, heightOpponent, ballanceOpponent;
    @FXML
    private Button goToRing, goConference, back, resign;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private HumanBoxer boxer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void goFightScreen(ActionEvent event) throws IOException {
        if (boxer.getQueue().getDaysLeftToFight() == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ring.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Nie czas jeszcze na walkę! Weź się za trening," + System.lineSeparator() +
                    " albo idź się przespać.");
            Optional<ButtonType> button = alert.showAndWait();
            if (button.get() == ButtonType.CLOSE)
                alert.close();
        }

    }

    @FXML
    void goToConference(ActionEvent event) {
        //todo
    }

    @FXML
    void backToMainScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void cancelFight(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Zrezygnuj z walki");
        alert.setHeaderText("Czy jesteś pewien, że chcesz zrezygnować?");
        alert.setContentText("Odbije się to negatywnie na Twojej popularności i prestiżu. " + System.lineSeparator() +
                "Utracisz " + boxer.getPrestige() / 5 + " prestiżu" + System.lineSeparator() +
                "Będziesz zobowiązany także do zwrotu kosztów organizacji walki: 15000$");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            boxer.resignFight();
        } else alert.close();
    }

}
