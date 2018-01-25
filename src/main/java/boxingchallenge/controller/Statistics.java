package boxingchallenge.controller;

import boxingchallenge.content.auxiliary.Draftsman;
import boxingchallenge.content.stats.Ranking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Statistics implements Initializable {
    @FXML private Button goBackB;
    @FXML private VBox placeVBox, nameVBox, prestigeVBox, titleVBox;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private Ranking ranking;

    @Autowired
    private Draftsman draftsman;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ranking.showList();
        draftsman.drawTable();
    }

    public void goBackMainScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public VBox getPlaceVBox() {
        return placeVBox;
    }

    public VBox getNameVBox() {
        return nameVBox;
    }

    public VBox getPrestigeVBox() {
        return prestigeVBox;
    }

    public VBox getTitleVBox() {
        return titleVBox;
    }

    public void backMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goBackB.getScene().getWindow();
        stage.setScene(scene);
    }
}
