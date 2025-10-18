package collectionslist;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FoodStore {

    /*Készíts egy Food osztályt, amelynek két attribútuma legyen:
    név és lejárati dátum (LocalDate)!
    Majd készíts egy FoodStore osztályt, amelynek van egy
    LinkedList típusú listája a benne tárolt élelmiszerekről,
    melyhez legyen getter metódus is! Legyen az osztálynak
    egy metódusa: addFood(Food food) metódusa,
    amely megvizsgálja a kapott élelmiszer lejárati dátumát és
    ha az a mai nappal egyezik meg, akkor a lista legelejére illeszti be!*/

    private List<Food> foods = new LinkedList<>();

    public List<Food> getFoods() {
        return new LinkedList<>(foods);
    }

    public void addFood(Food food) {
        if (food.getExpirationDate().equals(LocalDate.now())) {
            foods.add(0, food);
        } else {
            foods.add(food);
        }
    }
}


