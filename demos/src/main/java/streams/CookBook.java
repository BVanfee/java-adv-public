package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CookBook {

    /*Készíts egy Cake nevű osztályt, amelynek attribútumai: név és a hozzávalók
     listája (String lista)! Majd készíts egy CookBook nevű osztályt, amelynek
     van egy listája a süteményekről, és van egy List<String>
     listCakeNamesWithGivenIngredient(String ingredient) metódusa, mely visszaadja
     azon sütemények neveit, amelyekhez szükséges a megadott hozzávaló! Írj egy
     List<String> listCakeNamesWithMaxIngredients(int max) metódust is, amely
     visszaadja azon sütemények neveit egy listában, amelyekhez legfeljebb annyi
     hozzávaló szükséges, mint a paraméterül kapott szám!*/

    private List<Cake> cakes = new ArrayList<>();

    public CookBook(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public void addCake(Cake cake) {
        cakes.add(cake);
    }

    public List<String> listCakeNamesWithGivenIngredient(String ingredient) {
        return cakes.stream()
                .filter(cake -> cake.getIngredients().contains(ingredient))
                .map(Cake::getName)
                .collect(Collectors.toList());
    }

    public List<String> listCakeNamesWithMaxIngredients(int max) {
        return cakes.stream()
                .filter(cake -> cake.getIngredients().size() <= max)
                .map(Cake::getName)
                .collect(Collectors.toList());
    }
}
