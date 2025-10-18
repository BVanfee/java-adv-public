package sorting;

import java.util.Arrays;

public class Income {
    /*Készíts egy Income nevű osztályt, amelynek legyen egy
    olyan tömb attribútuma, amelyben egy cég egész éves árbevételei vannak,
    összevissza sorrendben! Írj egy int getHighestIncome() metódust, amely
    nagyság szerint sorba rendezi a tömb elemeit és visszaadja az idei legnagyobb árbevételt!*/

    private int[] incomes;

    public Income(int[] incomes) {
        this.incomes = incomes;
    }

    public int getHighestIncome() {
        Arrays.sort(incomes);
        return incomes[incomes.length - 1];
    }
}
