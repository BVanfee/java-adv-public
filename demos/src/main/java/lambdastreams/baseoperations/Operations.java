package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {

    /*Készíts egy baseoperations.Operations osztályt, amely egész számokból
    álló listát tárol! A listát a konstruktoron át kapja meg. Készíts metódusokat
    az alábbi számítások elvégzésére:

Optional<Integer> min(): a metódus adja vissza a legkisebb számot!
Integer sum(): a metódus adja vissza az elemek összegét!
boolean isAllPositive(): megvizsgálja, hogy minden elem pozitív-e.
Set<Integer> getDistinctElements(): az összes különböző elemet pontosan egyszer tartalmazó kollekció.
Az összes metódus kizárólag stream műveleteket használjon!*/

    private List<Integer> numbers;

    public Operations(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers
                .stream()
                //.min((n1, n2) -> n1 - n2);
                .min(Comparator.comparingInt(n -> n));
    }

    public Integer sum() {
        return numbers
                .stream()
                .mapToInt(number -> number)
                .sum();
    }

    public boolean isAllPositive() {
        return numbers
                .stream()
                .allMatch(number -> number > 0);
    }

    public Set<Integer> getDistinctElements(){
        return numbers
                .stream()
                .collect(Collectors.toSet());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
