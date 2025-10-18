package lambda;

import java.util.List;

public class Remainder {

    /*Készíts egy Remainder osztályt, melynek egyetlen metódusa:
    List<Integer> changeNumbersToRemainders(List<Integer> numbers, int divisor)!
    Ez a metódus cserélje ki a paraméterül kapott listában a számokat a következő
    módon: minden számot osszon el a szintén paraméterül kapott divisor-ral,
    és ennek az osztásnak a maradékát tegye az eredeti szám helyére!

Például ha az eredeti lista tartalma [45, 13, 64, 51, 92, 33],
akkor a metódus a következőt adja vissza 3-mal való osztás esetén: [0, 1, 1, 0, 2, 0]!*/

    public List<Integer> changeNumbersToRemainders(List<Integer> numbers, int divisor) {
        numbers.replaceAll(number -> number % divisor);
        return numbers;
    }
}
