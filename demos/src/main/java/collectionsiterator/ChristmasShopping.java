package collectionsiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChristmasShopping {

    List<ChristmasPresent> christmasPresents = new ArrayList<>();

    public ChristmasShopping(List<ChristmasPresent> christmasPresents) {
        this.christmasPresents = christmasPresents;
    }

    public void addNewPresent(ChristmasPresent present){
        christmasPresents.add(present);
    }

    public void removeTooExpensivePresent(int maxPrice){
        ListIterator<ChristmasPresent> iterator = christmasPresents.listIterator();
        while (iterator.hasNext()){
            int priceOfPresent = iterator.next().getPrice();
            if(priceOfPresent>maxPrice){
                iterator.remove();
            }
        }

    }

    public List<ChristmasPresent> getChristmasPresents() {
        return new ArrayList<>(christmasPresents);
    }

}
