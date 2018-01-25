package boxingchallenge.content.characters;

import boxingchallenge.content.auxiliary.Balance;

import java.util.Random;

public class AIBoxer extends AbstractBoxer {
    private Random random = new Random();

    public AIBoxer(){}

    public AIBoxer(String name, String nation, int age, long money, int prestige, int strenght,
                   int quickness, int accurancy, int psyche, int hardiness, Trainer defaultTrainer, int level) {
        super();
        setName(name);
        setNation(nation);
        if (age > 16 && age < 50)
            setAge(age);
        else throw new IllegalArgumentException();
        setMoney(money);
        setPrestige(prestige);
        setBalance(new Balance(level));
        if (strenght < 0 || quickness < 0 || accurancy < 0 || psyche < 0 || hardiness < 0)
            throw new IllegalArgumentException();
        else {
            setStrenght(strenght);
            setQuickness(quickness);
            setAccurancy(accurancy);
            setPsyche(psyche);
            setHardiness(hardiness);
        }
        setWeight(90.0 + random.nextInt(25));
        setHeight(175 + random.nextInt(35));
        setTrainer(defaultTrainer);
    }
}
