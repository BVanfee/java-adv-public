package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();


    public void readGradesFromFile(String file) {
        Path path = Path.of("src/main/resources/ioreader/" + file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addStudent(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File can not read");
        }

    }

    private void addStudent(String line) {
        String[] data = line.split(" ");
        String name = data[0];
        List<Integer> grades = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            grades.add(Integer.parseInt(data[i]));
        }
        students.add(new Student(name,grades));
    }

    public double classAverage() {
        return students
                .stream()
                .mapToDouble(Student::average)
                .average()
                .orElse(0.0);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
