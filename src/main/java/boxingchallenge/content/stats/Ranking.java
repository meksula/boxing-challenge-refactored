package boxingchallenge.content.stats;

import boxingchallenge.content.characters.AbstractBoxer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;

@Component
public class Ranking {
    private ArrayList<AbstractBoxer> boxersRanks = new ArrayList<>();

    public ArrayList<AbstractBoxer> getBoxersRanks() {
        return boxersRanks;
    }

    public void addBoxer(AbstractBoxer boxer) {
        if (!boxersRanks.contains(boxer)) {
            boxersRanks.add(boxer);
        }
    }

    public void showList() {
        sortRanking();
        for(AbstractBoxer boxer : boxersRanks){
            System.out.println(boxersRanks.indexOf(boxer) + 1 + ". " + boxer.getName() + ", [Prestiż:] " + boxer.getPrestige());
        }
    }

    public int getPlace(AbstractBoxer abstractBoxer) {
        int place = boxersRanks.indexOf(abstractBoxer);
        return place;
    }

    public void sortRanking() {
        boxersRanks.sort(Comparator.comparing(AbstractBoxer::getPrestige).reversed());
    }
}
