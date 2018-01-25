package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AbstractBoxer;

import java.util.Random;

public class Factors {
    private double chance;
    private Random random = new Random();
    private AbstractBoxer boxer;

    Factors(AbstractBoxer boxer){
        this.boxer = boxer;
    }

    public double condition(double dmg) {
        chance = random.nextInt(100);

        if (chance % 10 == 0 && chance < 50)
            return criticalHit(dmg);

        else if (chance % 7 == 0)
            return penetrationHit(dmg);

        else if (chance == 64)
            return knockOutHit(dmg);

        else if (happyness())
            return dmg + random.nextInt(30);

        else return dmg;
    }

    private boolean happyness() {
        boolean happy = random.nextBoolean();
        return happy;
    }

    private double criticalHit(double dmg) {
        return dmg + (dmg * 0.50);
    }

    private double penetrationHit(double dmg) {
        return dmg + boxer.getAccurancy();
    }

    private double knockOutHit(double dmg) {
        return dmg * boxer.getStrenght();
    }
}

