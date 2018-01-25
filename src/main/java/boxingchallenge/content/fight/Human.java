package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.AbstractBoxer;
import boxingchallenge.content.characters.HumanBoxer;

public class Human implements FightEngine {
    private HumanBoxer striker;
    private AIBoxer victim;
    private Factors factors;

    @Override
    public void setStriker(AbstractBoxer striker) {
        this.striker = (HumanBoxer) striker;
    }

    @Override
    public void setVictim(AbstractBoxer victim) {
        this.victim = (AIBoxer) victim;
    }

    @Override
    public void setFactors() {
        factors = new Factors(striker);
    }

    @Override
    public double attack(int index) {
        if (index == 0)
            return leftStrightHead();
        else if (index == 1)
            return rightStrightHead();
        else if (index == 2)
            return leftHookHead();
        else if (index == 3)
            return rightHookHead();
        else if (index == 4)
            return leftChinPunch();
        else if (index == 5)
            return rightChinPunch();
        else throw new IllegalArgumentException();
    }

    @Override
    public void getHelpFromTrainer() {
        if (striker.getTrainer() != null)
            striker.getTrainer().help();
        else defaultHelp();
    }

    @Override
    public void defaultHelp() {
        striker.setHealth(striker.getHealth() + 10);
        striker.setStamina(striker.getStamina() + 10);
    }

    //todo wzór metody
    public double leftStrightHead() {
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    private double rightStrightHead() {
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    private double leftHookHead(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    private double rightHookHead(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    private double leftChinPunch(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    private double rightChinPunch(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        return dmg = factors.condition(dmg);
    }

    public AIBoxer getVictim() {
        return victim;
    }

    public HumanBoxer getStriker() {
        return striker;
    }

    public Factors getFactors() {
        return factors;
    }
}