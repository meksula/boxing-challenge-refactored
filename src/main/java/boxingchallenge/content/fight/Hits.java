package boxingchallenge.content.fight;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Hits {
    private List<String> hits = new ArrayList<>();

    public Hits(){
        hits.add(0, "Lewy prosty (head)");
        hits.add(1, "Prawy prosty (head)");
        hits.add(2, "Lewy sierpowy (head)");
        hits.add(3, "Prawy sierpowy (head)");
        hits.add(4, "Lewy podbródkowy (head)");
        hits.add(5, "Prawy podbródkowy (head)");
    }

    public List<String> getHitList() {
        return hits;
    }

    public String pullHit(int index){
        return hits.get(index);
    }
}
