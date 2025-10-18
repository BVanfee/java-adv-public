package ioreader.grades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Student {
    /*A követező feladat egy osztálynapló nyilvántartása. A grades.txt fájl
     minden sora tartalmaz egy nevet és utána a tanuló jegyeit.
     Készíts egy Student osztályt mely a tanuló nevét és jegyeinek listáját
      képes tárolni! Legyen benne egy átlagszámító metódus, valamint egy metódus,
       ami képes eldönteni, hogy a tanuló jegyei emelkednek-e.

Készíts egy SchoolRecordsManager osztályt, ami beolvassa fájlból az adatokat,
eltárolja, és ezen felül még képes egy osztályátlag számítására is!*/

    private final String name;
    private final List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public boolean isIncreasing(){
        if (gradeList.size() <= 1) {
            return true;
        }
        return IntStream.range(0, gradeList.size() - 1)
                .allMatch(i -> gradeList.get(i) <= gradeList.get(i + 1));
    }

    public double average(){
        return gradeList
                .stream()
                .mapToInt(number -> number)
                .average()
                .orElse(0.0);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }
}
