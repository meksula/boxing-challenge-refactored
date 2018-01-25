package boxingchallenge.content.fight;

import boxingchallenge.content.auxiliary.Draftsman;
import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.HumanBoxer;
import boxingchallenge.content.fight.logic.AlgorithmAI;
import boxingchallenge.controller.Fight;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/*Metoda init() jest konieczna do wywołania na komponencie*/

@Component
public class Action {
    private int roundCounter = 1;
    private int moves = 0;
    private Rectangle opponentLifeStrip;
    private Rectangle humanLifeStrip;
    private Rectangle humanStaminaStrip;
    private Rectangle opponentStaminaStrip;
    private VBox hitBox;
    private boolean fightIsOver = false;
    Random random = new Random();

    private FightEngine humanEngine;
    private FightEngine opponentEngine;

    @Autowired
    private Fight fight;

    @Autowired
    private HumanBoxer human;

    @Autowired
    private Draftsman draftsman;

    @Autowired
    private Hits hits;

    @Autowired
    private AlgorithmAI algo;

    private AIBoxer opponent;

    public void init() {
        opponent = draftsman.getSummoned();

        humanEngine = new Human();
        humanEngine.setStriker(human);
        humanEngine.setVictim(opponent);
        humanEngine.setFactors();

        opponentEngine = new Opponent();
        opponentEngine.setStriker(opponent);
        opponentEngine.setVictim(human);
        opponentEngine.setFactors();

        hitBox = new VBox();
        hitBox.setLayoutX(580);
        hitBox.setLayoutY(50);
    }

    public void drawAvailableHits(){
        for (int i = 0; i < hits.getHitList().size(); i++){
            hitBox.getChildren().add(setNew(i));
        }
        fight.getAnchor().getChildren().add(hitBox);
    }

    public Label setNew(int index){
        Label label = new Label(hits.pullHit(index));
        label.setTextFill(Color.RED);

        label.setOnMouseEntered(event -> {
            label.setTextFill(Color.GREEN);
        });

        label.setOnMouseExited(event -> {
            label.setTextFill(Color.RED);
        });

        label.setOnMouseClicked(event -> {
            fightAction(index);
        });
        return label;
    }

    public void fightAction(int index) {
        fightIsOver = checkIfWin();
        moves++;

        int indexAI = algo.chooseMove();
        double humanDMG = humanEngine.attack(index);
        double opponentDMG = opponentEngine.attack(indexAI);
        summary(humanDMG, opponentDMG);

        if (moves == 3) {
            roundCounter++; moves = 0;
            humanEngine.getHelpFromTrainer();
            opponentEngine.getHelpFromTrainer();
        }
        fight.getRound().setText(String.valueOf("Runda: " + roundCounter));
        fightIsOver = checkIfWin();
    }

    public void summary(double humanDMG, double opponentDMG) {
        human.setHealth(human.getHealth() - humanDMG);
        opponent.setHealth(opponent.getHealth() - opponentDMG);
        refreshStripes();

        if (roundCounter > 12 || fightIsOver){
            fight.getAnchor().getChildren().clear();
        }
    }

    public void drawStripes() {
        opponentLifeStrip = new Rectangle(20, 20, opponent.getHealth(), 20);
        opponentLifeStrip.setFill(Color.RED);
        opponentLifeStrip.setStroke(Color.GOLD);
        fight.getAnchor().getChildren().add(opponentLifeStrip);

        opponentStaminaStrip = new Rectangle(230, 20, opponent.getStamina(), 20);
        opponentStaminaStrip.setFill(Color.GOLD);
        opponentStaminaStrip.setStroke(Color.DARKSLATEGRAY);
        fight.getAnchor().getChildren().add(opponentStaminaStrip);

        humanLifeStrip = new Rectangle(20, 470, human.getHealth(), 20);
        humanLifeStrip.setFill(Color.RED);
        humanLifeStrip.setStroke(Color.GOLD);
        fight.getAnchor().getChildren().add(humanLifeStrip);

        humanStaminaStrip = new Rectangle(230, 470, human.getStamina(), 20);
        humanStaminaStrip.setFill(Color.GOLD);
        humanStaminaStrip.setStroke(Color.DARKSLATEGRAY);
        fight.getAnchor().getChildren().add(humanStaminaStrip);
    }

    public void refreshStripes() {
        opponentLifeStrip.setWidth(opponent.getHealth());
        opponentStaminaStrip.setWidth(opponent.getStamina());
        humanLifeStrip.setWidth(human.getHealth());
        humanStaminaStrip.setWidth(human.getStamina());
    }

    public void removeStripes(){
        opponentStaminaStrip.setVisible(false);
        opponentLifeStrip.setVisible(false);
        humanStaminaStrip.setVisible(false);
        humanLifeStrip.setVisible(false);
    }

    public boolean checkIfWin() {
        if (human.getHealth() < 0) {
            System.out.println("Zwyciężył " + opponent.getName());
            hitBox.getChildren().clear();
            return true;
        }

        if (opponent.getHealth() < 0) {
            System.out.println("Zwyciężył " + human.getName());
            hitBox.getChildren().clear();
            return true;
        } else return false;
    }

    public int getRoundCounter() {
        return roundCounter;
    }
}
