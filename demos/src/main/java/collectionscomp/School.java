package collectionscomp;

import java.text.Collator;
import java.util.*;

public class School {

    public static void main(String[] args) {

        Student.StudentComparator comparator = new Student.StudentComparator();
        Set<Student> students = new TreeSet<>(comparator);

        students.add(new Student(185, "Ákos"));
        students.add(new Student(174, "Béla"));
        students.add(new Student(174, "Dominik"));
        students.add(new Student(178, "János"));
        students.add(new Student(186, "Tamás"));

        System.out.println(students);

        Map<String, Integer> studentsList = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));

        for (Student student : students) {
            studentsList.put(student.getName(),student.getHeight());
        }

        System.out.println(studentsList);
    }
}
