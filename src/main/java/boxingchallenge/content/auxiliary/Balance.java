package boxingchallenge.content.auxiliary;

import java.util.Random;

public class Balance {
    private Random random = new Random();
    private int win;
    private int draw;
    private int lose;

    public Balance(){}

    public Balance(int level){
        if (level == 0){
            setWin(random.nextInt(5));
            setDraw(random.nextInt(10));
            setLose(random.nextInt(30));
        }
        else if (level == 1){
            setWin(random.nextInt(10));
            setDraw(random.nextInt(10));
            setLose(random.nextInt(20));
        }
        else if (level == 2){
            setWin(random.nextInt(20));
            setDraw(random.nextInt(10));
            setLose(random.nextInt(10));
        }
        else if (level == 3){
            setWin(random.nextInt(40));
            setDraw(random.nextInt(10));
            setLose(random.nextInt(5));
        }
        else throw new IllegalArgumentException();
    }

    private Balance weakBalance() {
        Balance balance = new Balance();
        balance.setWin(random.nextInt(5));
        balance.setDraw(random.nextInt(10));
        balance.setLose(random.nextInt(20));
        return balance;
    }

    public String show() {
        return win + "-" + draw + "-" + lose;
    }

    public void addWin() {
        win += 1;
    }

    public void addDraw() {
        draw +=1;
    }

    public void addLose() {
        lose +=1;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
