package boxingchallenge.main;

import boxingchallenge.content.fight.Action;
import boxingchallenge.content.stats.Ranking;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
    @Autowired
    private Ranking ranking;

    @Autowired
    private Action act;

    @Pointcut("execution(* boxingchallenge.content.stats.Ranking.addBoxer())")
    public void point(){}

    @Pointcut("execution(* boxingchallenge.content.fight.Action.init())")
    public void action(){}

    @Pointcut("execution(* boxingchallenge.content.fight.Action.summary())")
    public void summary(){}

    @AfterReturning("point()")
    public void sort(){
        ranking.sortRanking();
    }

    @AfterReturning("action()")
    public void draw(){
        act.drawStripes();
        act.drawAvailableHits();
    }

    @AfterReturning("summary()")
    public void refresh(){
        act.refreshStripes();
    }

    /*@Pointcut("execution(* boxingchallenge.content.fight.FightEngine.getHelpFromTrainer())")
    public void help(){}

    @Before("help()")
    public void comment(){
        System.out.println("Czas na przerwę, obaj zawodnicy łapią trochę oddechu.");
    }*/
}
