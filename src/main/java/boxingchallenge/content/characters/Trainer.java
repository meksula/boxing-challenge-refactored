package boxingchallenge.content.characters;

import org.springframework.stereotype.Component;

@Component
public class Trainer {
    private String name;
    private String nation;

    private int staminaAbilities;
    private int healthAbilities;

    private AbstractBoxer boxer;

    public Trainer(String name, String nation){
        if (name.isEmpty() || nation.isEmpty())
            throw new IllegalArgumentException();
        else {
            this.name = name;
            this.nation = nation;
        }
    }

    //AI nie musi mieć trenera, który będzie się konkretnie nazywał
    public Trainer() {
        setName("John Smith");
        setNation("USA");
    }

    public void help() {
        if (200 > (boxer.getHealth() + healthAbilities))
            boxer.setHealth(boxer.getHealth() + healthAbilities);
        else if (200 < (boxer.getHealth() + healthAbilities))
            boxer.setHealth(200);

        if (200 > (boxer.getStamina() + staminaAbilities))
            boxer.setStamina(boxer.getHealth() + staminaAbilities);
        else if (200 < (boxer.getStamina() + staminaAbilities))
            boxer.setStamina(200);
    }

    public String showTrainer(){
        return this.getName() + ", " + this.getNation();
    }

    public String trainersAbilities(){
        return staminaAbilities + " " + healthAbilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public int getStaminaAbilities() {
        return staminaAbilities;
    }

    public void setStaminaAbilities(int staminaAbilities) {
        this.staminaAbilities = staminaAbilities;
    }

    public int getHealthAbilities() {
        return healthAbilities;
    }

    public void setHealthAbilities(int healthAbilities) {
        this.healthAbilities = healthAbilities;
    }

    public AbstractBoxer getBoxer() {
        return boxer;
    }

    public void acceptJob(AbstractBoxer boxer) {
        this.boxer = boxer;
    }
}
