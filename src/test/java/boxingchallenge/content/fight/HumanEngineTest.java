package boxingchallenge.content.fight;

import boxingchallenge.content.characters.AIBoxer;
import boxingchallenge.content.characters.HumanBoxer;
import boxingchallenge.content.config.SpringBoxerFactory;
import boxingchallenge.main.BoxingChallengeApplication;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBoxerFactory.class, BoxingChallengeApplication.class})
public class HumanEngineTest {
    private HumanEngine engine;
    private HumanBoxer human;
    private AIBoxer ai;

    private static final Logger logger = Logger.getLogger(BoxingChallengeApplication.class);

    @Autowired
    @Qualifier("fereira")
    public void setAi(AIBoxer ai) {
        this.ai = ai;
    }

    @Autowired
    public void setHuman(HumanBoxer human) {
        this.human = human;
    }

    @Before
    public void setUp(){
        engine = new HumanEngine(human, ai);
    }

    @Test
    public void shouldBeNotNull(){
        assertNotNull(ai);
        assertNotNull(human);
        assertNotNull(engine);
        assertTrue(human.getStrenght() > 0);
        assertTrue(ai.getStrenght() > 0);
    }

    @Test
    public void attackNo0(){
        double sum = 0;
        for (int i = 0; i < 10; i++){
            double dmg = engine.attack(0);
            logger.info("Lewy prosty na głowę: "+dmg);
            if (dmg > 0)
                sum = sum + dmg;
        }
        String med = "Średnia z 10 ciosów [attack(0)] : " + sum;
        logger.info(med);
    }

    @Test
    public void attackNo3(){
        double sum = 0;
        for (int i = 0; i < 10; i++){
            double dmg = engine.attack(3);
            logger.info("Lewy sierpowy na głowę: "+dmg);
            if (dmg > 0)
                sum = sum + dmg;
        }
        //sum = sum / 10;
        String med = "Średnia z 10 ciosów [attack(3)] : " + sum;
        logger.info(med);
    }


}