package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AbstractBoxer;

import java.util.Random;

public class Factors {
    private double chance;
    private Random random = new Random();
    private AbstractBoxer striker;
    private AbstractBoxer victim;

    private double [] ratio = new double[20];

    Factors(AbstractBoxer striker, AbstractBoxer victim){
        this.striker = striker;
        this.victim = victim;

        if (striker.getAccurancy() > victim.getAccurancy()){
            for (int i = 0; i < ratio.length; i++){
                ratio[i] = (-5 + i) * 0.1;
            }
        } else for (int i = 0; i < ratio.length; i++) {
            ratio[i] = (-10 + i) * 0.1;
        }

    }

    public double condition(double dmg) {
        chance = random.nextInt(100);

        dmg = dmg * ratio[random.nextInt(20)];
        dmg = dmg - (victim.getHardiness() * 0.1);

        if (chance % 10 == 0 && chance < 50)
            return criticalHit(dmg);

        if (chance % 7 == 0)
            return penetrationHit(dmg);

        if (chance == 64)
            return knockOutHit(dmg);

        if (happyness())
            return dmg + random.nextInt(30);

        else return dmg;
    }

    private boolean happyness() {
        boolean happy = random.nextBoolean();
        return happy;
    }

    private double criticalHit(double dmg) {
        return dmg + (dmg / 0.50);
    }

    private double penetrationHit(double dmg) {
        return dmg + striker.getAccurancy();
    }

    private double knockOutHit(double dmg) {
        return dmg * striker.getStrenght();
    }
}

