package boxingchallenge.content.characters;

import boxingchallenge.content.auxiliary.Balance;

public abstract class AbstractBoxer {
    /*Required to create boxer*/
    private String name;
    private String nation;

    /*Every boxer's properties*/
    private int age;
    private int prestige;
    private int rankPlace;
    private long money;
    private Trainer trainer;
    private Balance balance;

    /*Atributes*/
    private double health = 200;
    private double stamina = 200;
    private int strenght;
    private int quickness;
    private int accurancy;
    private int psyche;
    private int hardiness;
    private double weight;
    private double height;

    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
        else throw new IllegalArgumentException();
    }

    public void setNation(String nation) {
        if (!name.isEmpty())
            this.nation = nation;
        else throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrestige() {
        return prestige;
    }

    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }

    public int getRankPlace() {
        return rankPlace;
    }

    public void setRankPlace(int rankPlace) {
        this.rankPlace = rankPlace;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getQuickness() {
        return quickness;
    }

    public void setQuickness(int quickness) {
        this.quickness = quickness;
    }

    public int getAccurancy() {
        return accurancy;
    }

    public void setAccurancy(int accurancy) {
        this.accurancy = accurancy;
    }

    public int getPsyche() {
        return psyche;
    }

    public void setPsyche(int psyche) {
        this.psyche = psyche;
    }

    public int getHardiness() {
        return hardiness;
    }

    public void setHardiness(int hardiness) {
        this.hardiness = hardiness;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public void fireYourTrainer(){
        this.trainer = null;
    }
}
