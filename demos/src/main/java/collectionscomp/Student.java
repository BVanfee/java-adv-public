package collectionscomp;

import java.util.Comparator;
import java.util.Objects;

public class Student {

    /*Készíts egy Student osztályt, amelynek két attribútuma legyen:
    név és magasság (centiméterben)! Írd felül az osztály toString()
    metódusát! Készíts egy StudentComparator osztályt is,
    amely implementálja a Comparator interfészt, és úgy valósítja
    meg annak compare() metódusát, hogy a tanulókat a magasságuk
    szerint hasonlítja össze! Majd legyen egy School osztály!
    Ennek main() metódusában példányosíts egy TreeSet-et, amelynek
    konstruktor paraméterül adj át egy StudentComparator-t!
    Példányosíts le néhány tanulót, add őket a Set-hez és írd
    ki a kollekciót a konzolra, és nézd meg, hogy a tanulók
    magasság szerinti sorrendben fognak szerepelni!

Ezután példányosíts egy Map<String, Integer>-t is,
amely TreeMap legyen! Ennek adj át konstruktor paraméterül
egy Collator-t, Magyarországra érvényes Locale-lal!
Ehhez a Map-hez úgy add hozzá az előzőleg példányosított
tanulókat, hogy a Map kulcsai a tanulók nevei, az értékek
pedig a tanulók magasságai legyenek! Ezután írd ki ezt a
kollekciót is a konzolra, és nézd meg, hogy a Map bejegyzései
a tanulók nevei szerinti ábécésorrendben fognak szerepelni!*/
    private String name;
    private int height;

    public Student(int height, String name) {
        this.height = height;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return height == student.height && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getHeight() == o2.getHeight()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getHeight() - o2.getHeight();
            }
        }
    }
}
