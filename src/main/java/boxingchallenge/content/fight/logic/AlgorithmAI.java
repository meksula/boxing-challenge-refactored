package boxingchallenge.content.fight.logic;

import org.springframework.stereotype.Component;

import java.util.Random;

/*Klasa, która dostarcza metodę, w której znajduje się algorytm opisujący zachowanie gracza AI */

@Component
public class AlgorithmAI {
    private Random random = new Random();

    public int chooseMove() {
        return random.nextInt(5);
    }

   /*todo tutaj określić kilka poziomów zachowań bokserów w zależności od ich poziomu określonego na starcie
    public int chooseMove(){

    }*/
}
