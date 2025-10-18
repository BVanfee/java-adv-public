package lambdaintermediate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongWords {

    /*Készíts egy LongWords osztályt, amelynek legyen egy szavakat tartalmazó
    lista attribútuma! Az osztály metódusait streamek segítségével implementáld:

long getNumberOfWordsStartWith(String keyWord): visszaadja, hány szó kezdődik
a megadott kulcsszóval.
List<String> getLongerWords(int number): visszaadja azon szavak listáját,
amelyek a paraméterként megadott számnál több betűből állnak.
Optional<String> getShortestWordContainingGivenCharacter(char character):
visszaadja a legrövidebb olyan szót, amely tartalmazza a megadott karaktert.*/

    private List<String> words = new ArrayList<>();

    public LongWords(List<String> words) {
        this.words = words;
    }

    public long getNumberOfWordsStartWith(String keyWord) {
        return words
                .stream()
                .filter(word -> word.startsWith(keyWord))
                .count();
    }

    public List<String> getLongerWords(int number) {
        return words
                .stream()
                .filter(word -> word.length() > number)
                .collect(Collectors.toList());
    }

    public Optional<String> getShortestWordContainingGivenCharacter(char character) {
        return words
                .stream()
                .filter(word -> word.indexOf(character) > -1)
                .min(Comparator.comparing(String::length));
    }

    public List<String> getWords() {
        return new ArrayList<>(words);
    }
}
