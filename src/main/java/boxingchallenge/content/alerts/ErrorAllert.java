package boxingchallenge.content.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ErrorAllert {
    public static void throwErrorAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Błąd!");
        alert.setHeaderText("Wypełnij okienka tekstowe " + System.lineSeparator() +
                "Potem przejdź dalej.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            alert.close();
    }

    public static void regexError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Błąd!");
        alert.setHeaderText("Niepoprawne dane! " + System.lineSeparator() +
        "Imię i nazwisko zaczyna się od wielkiej litery.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            alert.close();
    }

    public static void wakeUpAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dzień dobry!");
        alert.setHeaderText("Nastał nowy dzień, " + System.lineSeparator() +
                "wykorzystaj go jak najlepiej!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.APPLY)
            alert.close();
    }

    public void sureForClose(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wyjdź");
        alert.setHeaderText("Czy jesteś pewien, że chcesz wyjść?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        }
        else alert.close();
    }
}
