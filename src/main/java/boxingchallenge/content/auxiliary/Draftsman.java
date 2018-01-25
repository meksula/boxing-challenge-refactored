package boxingchallenge.content.auxiliary;

import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.AbstractBoxer;
import boxingchallenge.content.characters.HumanBoxer;
import boxingchallenge.content.stats.Ranking;
import boxingchallenge.controller.Statistics;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

/*
* Klasa do refaktoryzacji - mocno zaśmiecona i nie wiadomo o co chodzi
*
*/

@Component
public class Draftsman {

    @Autowired
    private Ranking ranking;

    @Autowired
    private Statistics statistics;

    @Autowired
    private HumanBoxer humanBoxer;

    private AIBoxer summoned;

    public AIBoxer getSummoned() {
        return summoned;
    }

    /*that's not look good ;/ */
    public void removeSummoned(){
        summoned = new AIBoxer();
        summoned = null;
    }

    public void drawTable() {
        Label master = new Label("Mistrz ligi lokalnej");
        master.setTextFill(Color.GOLD);
        statistics.getTitleVBox().getChildren().add(master);

        Label pretendent = new Label("Pretendent do tytułu");
        pretendent.setTextFill(Color.SILVER);
        statistics.getTitleVBox().getChildren().add(pretendent);

        for (int i = 0; i < ranking.getBoxersRanks().size(); i++){
            Label placeLabel = new Label(String.valueOf(i + 1));
            placeLabel.setTextFill(Color.WHITE);
            statistics.getPlaceVBox().getChildren().add(placeLabel);

            Label nameLabel = new Label(ranking.getBoxersRanks().get(i).getName());
            nameLabel.setTextFill(Color.WHITE);
            statistics.getNameVBox().getChildren().add(nameLabel);

            Label prestigeLabel = new Label(String.valueOf(ranking.getBoxersRanks().get(i).getPrestige()));
            prestigeLabel.setTextFill(Color.WHITE);
            statistics.getPrestigeVBox().getChildren().add(prestigeLabel);

            if (ranking.getBoxersRanks().get(i).getPrestige() < humanBoxer.getPrestige()) {
                nameLabel.setOnMouseEntered(event -> {
                    placeLabel.setTextFill(Color.GOLD);
                    nameLabel.setTextFill(Color.GOLD);
                    prestigeLabel.setTextFill(Color.GOLD);
                });

                if (!humanBoxer.getQueue().isNextFight()){
                    nameLabel.setOnMouseClicked(event -> {
                        int indexTemp = Integer.parseInt(placeLabel.getText());
                        summoned = (AIBoxer) ranking.getBoxersRanks().get(indexTemp - 1);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Przeciwnik wyzwany!");
                        alert.setHeaderText("Czy na pewno chcesz wyzwać tego zawodnika?" + System.lineSeparator() +
                                "Rzucasz wyzwanie: " + summoned.getName() + " z " + summoned.getNation() + System.lineSeparator() +
                                ", który ma bilans walk: " + summoned.getBalance().show());
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (buttonType.get() == ButtonType.OK){
                            alert.close();

                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Przeciwnik wyzwany!");
                            alert.setHeaderText("Twój pojedynek już niebawem. " + System.lineSeparator() +
                                    "Wykorzystaj ten czas i przygotuj się do walki z " + summoned.getName());
                            Optional<ButtonType> buttonType2 = alert.showAndWait();
                            if (buttonType2.get() == ButtonType.OK){
                                alert2.close();
                                try {
                                    humanBoxer.getQueue().setDaysLeftToFight(0); //todo // zmiana!
                                    humanBoxer.getQueue().setNextFight(true);
                                    ranking.sortRanking();
                                    statistics.backMain();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else alert.close();
                    });
                }

                nameLabel.setOnMouseExited(event -> {
                    placeLabel.setTextFill(Color.WHITE);
                    nameLabel.setTextFill(Color.WHITE);
                    prestigeLabel.setTextFill(Color.WHITE);
                });
            }
        }
    }
}
