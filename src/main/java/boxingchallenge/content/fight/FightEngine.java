package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AbstractBoxer;

public interface FightEngine {
    void setStriker(AbstractBoxer striker);
    void setVictim(AbstractBoxer victim);
    void setFactors();
    double attack(int index);

    void getHelpFromTrainer();
    void defaultHelp();
}
