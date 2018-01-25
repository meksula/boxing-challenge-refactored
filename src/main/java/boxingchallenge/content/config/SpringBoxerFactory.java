package boxingchallenge.content.config;

import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.Trainer;
import boxingchallenge.content.stats.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBoxerFactory {
    /*Kilka beanów z domyślnymi trenerami*/
    @Autowired
    private Ranking ranking;

    @Bean
    public Trainer weakTrainer(){
        Trainer trainer = new Trainer();
        trainer.setStaminaAbilities(10);
        trainer.setHealthAbilities(12);
        return trainer;
    }

    @Bean
    public Trainer mediumTrainer(){
        Trainer trainer = new Trainer();
        trainer.setStaminaAbilities(18);
        trainer.setHealthAbilities(22);
        return trainer;
    }

    @Bean
    public Trainer goodTrainer(){
        Trainer trainer = new Trainer();
        trainer.setStaminaAbilities(30);
        trainer.setHealthAbilities(40);
        return trainer;
    }

    @Bean
    public Trainer superTrainer(){
        Trainer trainer = new Trainer();
        trainer.setStaminaAbilities(50);
        trainer.setHealthAbilities(50);
        return trainer;
    }

    /*Zawodnicy, trochę nieczytelnie, ale ...*/

    @Bean("defraux")
    public AIBoxer boxer() {
        AIBoxer boxer = new AIBoxer("Francis Defraux", "France",
                28, 12000, 86,
                29, 43, 34, 65, 64,
                weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("brown")
    public AIBoxer boxer2() {
        AIBoxer boxer = new AIBoxer("Christopher Brown", "Germany",
                30, 12000, 56,
                49, 43, 34, 35, 54,
                weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("smith")
    public AIBoxer boxer3(){
        AIBoxer boxer = new AIBoxer("Kenny Smith", "Canada", 25, 4333, 54, 21, 20, 17,10, 21, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("reaves")
    public AIBoxer boxer4(){
        AIBoxer boxer = new AIBoxer("John Reaves", "USA", 19, 2455, 23, 13, 14, 10, 10, 6, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("herrera")
    public AIBoxer boxer5(){
        AIBoxer boxer = new AIBoxer("Miguel Herrera", "Mexic", 22, 245, 33, 10, 34, 11, 10, 12, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("douglas")
    public AIBoxer boxer6(){
        AIBoxer boxer = new AIBoxer("Tonny Douglas jr.", "USA", 24, 9030, 62, 19, 29, 20, 10, 24, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("smiles")
    public AIBoxer boxer7(){
        AIBoxer boxer = new AIBoxer("Andy Smiles", "USA", 29, 10, 12, 13, 13, 14, 10, 10, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("fereira")
    public AIBoxer boxer8() {
        AIBoxer boxer = new AIBoxer("Alvaro Fereira", "Panama", 17, 2000, 20, 21, 6, 7, 12, 6, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("abnali")
    public AIBoxer boxer9() {
        AIBoxer boxer = new AIBoxer("Mohhamed Abn-Ali", "USA", 17, -5000, -10,  12, 5, 7, 10, 3, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("murphy")
    public AIBoxer boxer10() {
        AIBoxer boxer = new AIBoxer("Dan Murphy", "USA", 21, 1020, 22, 61, 54, 5, 23, 10, weakTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("morisson")
    public AIBoxer boxer11() {
        AIBoxer boxer =  new AIBoxer("Tim Morisson", "USA", 31, -5330, 65, 34, 35, 25, 43, 10, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("enis")
    public AIBoxer boxer12() {
        AIBoxer boxer = new AIBoxer("Rick Enis", "USA", 36, -53330, -65, 44, 27, 4, 9, 10, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("morales")
    public AIBoxer boxer13() {
        AIBoxer boxer = new AIBoxer("Antonio Jose Morales", "Cuba", 26, 2000, 81, 45, 27, 32, 29, 10, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("hathermann")
    public AIBoxer boxer14() {
        AIBoxer boxer = new AIBoxer("Jason Hathermann", "USA", 26, 20000, 91, 65, 47, 32, 43, 45, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("verechnkuck")
    public AIBoxer boxer15() {
        AIBoxer boxer = new AIBoxer("Andriej Verechnkuck", "Ukraine", 19, 20000, -1, 15, 17, 12, 13, 15, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("niewiadomski")
    public AIBoxer boxer16() {
        AIBoxer boxer = new AIBoxer("Marcin Niewiadomski", "Polska", 19, 20000, -10, 25, 7, 4, 43, 5, mediumTrainer(), 0);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("choroshchew")
    public AIBoxer boxer17() {
        AIBoxer boxer = new AIBoxer("Ivan Choroshchew", "Russia", 29, 20000, 100, 29, 47, 44, 52, 65, mediumTrainer(), 1);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("jonsson")
    public AIBoxer boxer18() {
        AIBoxer boxer = new AIBoxer("David Jonsson", "England", 30, 39999, 123, 43, 40, 34, 62, 35, mediumTrainer(), 1);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("mcevely")
    public AIBoxer boxer19() {
        AIBoxer boxer = new AIBoxer("Peter McEvely", "England", 17, 139999, 138, 73, 60, 84, 62, 95, mediumTrainer(), 1);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("chazarnichenko")
    public AIBoxer boxer20() {
        AIBoxer boxer = new AIBoxer("Nikolai Chazarnichencko", "Russia", 17, 139999, 140, 79, 50, 54, 90, 75, mediumTrainer(), 1);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("diperotti")
    public AIBoxer boxer21() {
        AIBoxer boxer = new AIBoxer("Marco di Perotti", "Italy", 21, 200300, 150, 89, 85, 101, 90, 85, mediumTrainer(), 2);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("rodriguez")
    public AIBoxer boxer22() {
        AIBoxer boxer = new AIBoxer("Santiago Manuel Rodriguez", "Mexico", 21, 200300, 150, 89, 85, 101, 90, 85, mediumTrainer(), 2);
        ranking.addBoxer(boxer);
        return boxer;
    }

    @Bean("whitaker")
    public AIBoxer boxer23() {
        AIBoxer boxer = new AIBoxer("Mike Whitaker", "USA", 23, 200300, 174, 109, 84, 121, 124, 96, goodTrainer(), 2);
        ranking.addBoxer(boxer);
        return boxer;
    }
}
