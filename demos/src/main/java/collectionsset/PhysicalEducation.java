package collectionsset;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PhysicalEducation {

    public Set<Integer> getHeightsInOrder(List<Student> students){
        Set<Integer> result = new TreeSet<>();
        for (Student student : students) {
            result.add(student.getHeight());
        }
        return result;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Tamás",185);
        Student student2 = new Student("Bogi",165);
        Student student3 = new Student("Bálint",195);
        Student student4 = new Student("János",172);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        PhysicalEducation education = new PhysicalEducation();

        System.out.println(education.getHeightsInOrder(students));


    }
}
