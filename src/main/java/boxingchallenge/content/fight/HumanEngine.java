package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.AbstractBoxer;
import boxingchallenge.content.characters.HumanBoxer;

public class HumanEngine implements FightEngine {
    private HumanBoxer striker;
    private AIBoxer victim;
    private Factors factors;

    public HumanEngine(HumanBoxer striker, AIBoxer victim){
        this.striker = striker;
        this.victim = victim;
        setFactors();
    }

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
        factors = new Factors(striker, victim);
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
        System.out.println("Domyślna pomoc");
    }

    public double leftStrightHead() {
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        striker.setStamina(striker.getStamina() - 10);
        return dmg = factors.condition(dmg);
    }

    private double rightStrightHead() {
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        striker.setStamina(striker.getStamina() - 10);
        return dmg = factors.condition(dmg);
    }

    private double leftHookHead(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        striker.setStamina(striker.getStamina() - 15);
        return dmg = factors.condition(dmg);
    }

    private double rightHookHead(){
        double dmg = ((striker.getStrenght() / 0.1) + ((striker.getAccurancy() * 0.6 + striker.getQuickness() * 0.4) -60) / 4);
        striker.setStamina(striker.getStamina() - 15);
        return dmg = factors.condition(dmg);
    }

    private double leftChinPunch(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        striker.setStamina(striker.getStamina() - 17);
        return dmg = factors.condition(dmg);
    }

    private double rightChinPunch(){
        double dmg = (striker.getStrenght() / 2) + (striker.getAccurancy() / 2) / 4;
        striker.setStamina(striker.getStamina() - 17);
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
