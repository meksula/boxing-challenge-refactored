package boxingchallenge.content.auxiliary;

import org.springframework.stereotype.Component;

@Component
public class GameplayQueue {
    private int gameDay = 1;
    private boolean move;

    private boolean nextFight = false;
    private int daysLeftToFight = 15;

    public void nextDay(){
        gameDay++;
        daysLeftToFight--;
    }

    public int getGameDay() {
        return gameDay;
    }

    public int getDaysLeftToFight() {
        return daysLeftToFight;
    }

    public void setDaysLeftToFight(int daysLeftToFight) {
        this.daysLeftToFight = daysLeftToFight;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isNextFight() {
        return nextFight;
    }

    public void setNextFight(boolean nextFight) {
        this.nextFight = nextFight;
    }
}
