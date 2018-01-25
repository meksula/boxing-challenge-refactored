package boxingchallenge.controller;

import boxingchallenge.content.auxiliary.Draftsman;
import boxingchallenge.content.characters.HumanBoxer;
import boxingchallenge.content.stats.Ranking;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class MainGame implements Initializable{
    @FXML private Label prestigeLabel, moneyLabel, rankLabel, nameLabel, nationLabel, strongLabel,
                        quicknessLabel, accurancyLabel, psycheLabel, weightLabel, nextFight, countDayToFight;

    @FXML private Button trainingB, rankingB, fightB, jobB, shopB, goBed, closeB;

    /*@FXML private ImageView canMove;
    private Image can = new Image("/img/yes.png");
    private Image canot = new Image("/img/no.png");*/

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private HumanBoxer boxer;

    @Autowired
    private Draftsman draftsman;

    @Autowired
    private Ranking ranking;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if (boxer.getQueue().isMove())
            canMove.setImage(can);
        else canMove.setImage(canot);*/

        prestigeLabel.setText(String.valueOf(boxer.getPrestige()));
        moneyLabel.setText(String.valueOf(boxer.getMoney()));
        boxer.setRankPlace(ranking.getPlace(boxer));
        rankLabel.setText(String.valueOf(boxer.getRankPlace()+1));
        nameLabel.setText(boxer.getName());
        nationLabel.setText(boxer.getNation());
        strongLabel.setText(String.valueOf(boxer.getStrenght()));
        quicknessLabel.setText(String.valueOf(boxer.getQuickness()));
        accurancyLabel.setText(String.valueOf(boxer.getAccurancy()));
        psycheLabel.setText(String.valueOf(boxer.getPsyche()));
        weightLabel.setText(String.valueOf(boxer.getWeight()));

        if (boxer.getQueue().isNextFight()){
            nextFight.setVisible(true);
            countDayToFight.setVisible(true);
            countDayToFight.setText(String.valueOf(boxer.getQueue().getDaysLeftToFight()));
        } else {
            nextFight.setVisible(false);
            countDayToFight.setVisible(false);
        }

        if (draftsman.getSummoned() != null){
            nextFight.setText("Dni do walki: ");
            countDayToFight.setText(String.valueOf(boxer.getQueue().getDaysLeftToFight()));
            nextFight.setVisible(true);
            countDayToFight.setVisible(true);
        }

        if (boxer.getQueue().getDaysLeftToFight() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Nadszedł dzień walki," + System.lineSeparator()+
                    " jedz śniadanie, bo limuzyna już czeka.");
            Optional<ButtonType> button = alert.showAndWait();
            if(button.get() == ButtonType.CLOSE)
                alert.close();
        }

        if (boxer.getQueue().getDaysLeftToFight() == 3){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Walka już niebawem," + System.lineSeparator()+
                    " czas się pakować i ruszać na lotnisko.");
            Optional<ButtonType> button = alert.showAndWait();
            if(button.get() == ButtonType.CLOSE)
                alert.close();
        }
    }

    @FXML
    public void goTraining(ActionEvent event) {
        System.out.println(draftsman.getSummoned().getName());
    }

    @FXML
    public void showRank(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/statistics.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void goFight(ActionEvent event) throws IOException {
        if (boxer.getQueue().isNextFight()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/weighting.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Musisz najpierw wybrać swojego przeciwnika!");
            alert.setTitle("Wybierz przeciwnika");
            alert.setContentText("W tym celu przejdź do ekranu ze statystykami.");
            Optional<ButtonType> buttonType = alert.showAndWait();

        }
    }

    @FXML
    public void getJob(ActionEvent event) {

    }

    @FXML
    public void goShoping(ActionEvent event) {

    }

    @FXML
    public void goSleep(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/sleep.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void saveAndClose(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wyjdź");
        alert.setHeaderText("Czy jesteś pewien, że chcesz wyjść?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            context.stop();
            System.exit(0);
        }
        else alert.close();
    }
}
