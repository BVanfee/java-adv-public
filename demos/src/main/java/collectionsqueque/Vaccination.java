package collectionsqueque;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Vaccination {

    /*Egy járványos betegségre kifejlesztett vakcina
    nem adható gyerekeknek (18 év alattiaknak),
    valamint 65 év feletti felnőtteknek sem. Sőt,
    mivel eléggé megterheli a szervezetet, az a legjobb,
    ha minél fiatalabb, aki kapja.

Hozz létre egy Person osztályt,
melynek két attribútuma van: név és életkor!
Hozz létre egy Vaccination osztályt is,
amelyben legyen egy
Queue<Integer> getVaccinationOrder(List<Person> people) metódus,
amely az emberek listájából kiválogatja a 18 évnél nem fiatalabb
és a 65 évnél nem idősebb embereket, és az életkorukat
egy PriorityQueue-ban adja vissza.
Az osztály main() metódusában példányosítsd le a listát,
adj hozzá néhány embert (mindenféle életkorút),
majd hívd meg a listával a getVaccinationOrder() metódust!
Írd ki a kapott értéket a konzolra! Majd hívd meg a kapott
PriorityQueue-n a poll() metódust, és írd ki a konzolra,
melyik értéket veszi ki először!*/

    public Queue<Integer> getVaccinationOrder(List<Person> people) {
        Queue<Integer> olderThan18AndYoungerThan65 = new PriorityQueue<>();

        for (Person person : people) {
            if (person.getAge() >= 18 && person.getAge() <= 65) {
                olderThan18AndYoungerThan65.add(person.getAge());
            }
        }
        return olderThan18AndYoungerThan65;
    }

    public static void main(String[] args) {
        Vaccination vaccination = new Vaccination();

        List<Person> people = new ArrayList<>(List.of
                (new Person("Mari néni", 69),
                        new Person("Józsi bácsi", 62),
                        new Person("Marci", 5),
                        new Person("Béla", 19),
                        new Person("Ágota", 35),
                        new Person("Viktor", 21)));

        System.out.println(vaccination.getVaccinationOrder(people));

        Queue<Integer> ageInOrder= vaccination.getVaccinationOrder(people);
        int index = ageInOrder.size();

        for (int i = 0; i < index; i++) {
            System.out.println(ageInOrder.poll());
        }

    }
}
