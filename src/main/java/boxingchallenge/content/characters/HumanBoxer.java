package boxingchallenge.content.characters;

import boxingchallenge.content.alerts.ErrorAllert;
import boxingchallenge.content.auxiliary.Balance;
import boxingchallenge.content.auxiliary.Draftsman;
import boxingchallenge.content.auxiliary.GameplayQueue;
import boxingchallenge.content.stats.Ranking;
import boxingchallenge.controller.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class HumanBoxer extends AbstractBoxer {
    private final int CONSTANT = 10;
    private Random random = new Random();
    private GameplayQueue queue;

    @Autowired
    private Creator creator;

    @Autowired
    private Ranking ranking;

    @Autowired
    private Draftsman draftsman;

    public HumanBoxer(){
        super();
        setAge(18);
        setMoney(100);
        setPrestige(0);
        setBalance(new Balance());
        setQueue(new GameplayQueue());
        setStrenght(CONSTANT);
        setQuickness(CONSTANT);
        setAccurancy(CONSTANT);
        setPsyche(CONSTANT);
        setHardiness(CONSTANT);
        setWeight(90.0);
        setHeight(175 + random.nextInt(35));
    }

    public void hireTrainer(Trainer trainer) {
        setTrainer(trainer);
        trainer.acceptJob(this);
    }

    public GameplayQueue getQueue() {
        return queue;
    }

    public void setQueue(GameplayQueue queue) {
        this.queue = queue;
    }

    public void creationCondition() {
        do {
            if (!creator.getName().getText().isEmpty() && !creator.getNation().getText().isEmpty()) {
                Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,10}\\s[A-Z][a-z,ł,ż,ó,ę,ą]{2,12}");
                Pattern nationPattern = Pattern.compile("[A-Z][a-z]{3,10}");

                Matcher nameMatcher = namePattern.matcher(creator.getName().getCharacters());
                Matcher nationMatcher = nationPattern.matcher(creator.getNation().getCharacters());

                if (nameMatcher.matches() && nationMatcher.matches()){
                    this.setName(creator.getName().getText());
                    this.setNation(creator.getNation().getText());
                    ranking.addBoxer(this);
                    setRankPlace(ranking.getPlace(this) + 1);
                } else ErrorAllert.regexError();
            } else {
                ErrorAllert.throwErrorAlert();
                throw new IllegalArgumentException();
            }
        }
        while (!this.getName().equals(creator.getName().getText()) && !this.getNation().equals(creator.getNation().getText()));
    }

    public void resignFight(){
        this.getQueue().setNextFight(false);
        if (this.getPrestige() > 0)
            this.setPrestige(this.getPrestige() - (this.getPrestige()/5));
        else this.setPrestige(this.getPrestige() - 10);

        this.getQueue().setMove(false);
        draftsman.removeSummoned();
    }
}
