package boxingchallenge.content.auxiliary;

import boxingchallenge.controller.Sleep;
import boxingchallenge.main.BoxingChallengeApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*Klasa odpowiadająca za kontrolę spania*/

@Component
public class AnimationTimer {
    private javafx.animation.AnimationTimer timer;
    private long restTime = 0;
    private int i;

    private static Logger log = Logger.getLogger(BoxingChallengeApplication.class);

    @Autowired
    private Sleep sleep;

    public void timerStart(){
        timer = new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                if(restTime == 0)
                    restTime = now;
                if(now - restTime > 1000000000){
                    i++;
                    restTime = now;
                    sleep.getSleepTimeRest().setText(String.valueOf(i/3 + " godzin"));
                    if (i == 20){
                        sleep.timeToWakeUp();
                    }
                    else if (i == 24){
                        timer.stop();
                        i = 0;
                        try {
                            sleep.backMainScreen();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        timer.start();
    }
}
