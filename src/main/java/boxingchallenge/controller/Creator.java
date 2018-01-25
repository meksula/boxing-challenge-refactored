package boxingchallenge.controller;

import boxingchallenge.content.characters.HumanBoxer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Creator {
    @FXML private Button ready;
    @FXML private TextField name, nation;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    public HumanBoxer boxer;

    public void createdAndPlay(ActionEvent event) throws IOException {
        boxer.creationCondition();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ready.getScene().getWindow();
        stage.setScene(scene);
    }

    public TextField getName() {
        return name;
    }

    public TextField getNation() {
        return nation;
    }
}