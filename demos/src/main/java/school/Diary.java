package school;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Diary {
    private Files files;

    /*Készíts a school csomagban egy Diary nevű osztályt benne egy newMark() metódussal,
     ami paraméterül várja a tanuló nevét és egy jegyet! Ha létezik a "tanulo_neve.txt"
     akkor a jegyet hozzáfűzi az állomány végére. Ha nem, akkor egy új állományt hoz
     létre "tanulo_neve.txt" formátumban, és beleírja a jegyet. Azt, hogy létezik-e
     egy fájl a Files.exists(path) metódussal tudod eldönteni. A fájlok a
     src/main/resources/ könyvtárban legyenek!

Az év végén a tanár szeretné a tanuló fájl utolsó sorába az átlagot beírni.
Írj egy metódust average() névvel, ami a fájl utolsó sorába a jegyek átlagát
írja be! Például "average: 5".*/


    public void newMark(String studentName, int number) {
        validate(studentName);
        validate(number);
        Path path = getPath(studentName);
        try {
            if (Files.exists(path)) {
                Files.writeString(path, number + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(path, number + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }

    }

    public void average(String studentName) {
        validate(studentName);
        Path path = getPath(studentName);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("There is no file: " + path);
        }
        List<String> notes = getNotes(path);
        double average = getAverage(notes);
        try {

            Files.writeString(path, "average: " + average + "\n", StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new IllegalArgumentException("There is no file: " + path);
        }
    }

    private List<String> getNotes(Path path) {
        try {
            List<String> notes = Files.readAllLines(path);
            return notes;
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }

    }

    private double getAverage(List<String> notes) {
        return notes
                .stream()
                .filter(note -> !note.contains("average"))
                .mapToInt(note -> Integer.parseInt(note))
                .average()
                .orElseThrow(() -> new IllegalArgumentException("This student does not have note."));
    }

    private Path getPath(String studentName) {
        String pathString = "demos/src/main/resources/school/" + studentName.toLowerCase().replace(" ", "_").concat(".txt");
        Path path = Path.of(pathString);
        return path;
    }

    private void validate(String studentName) {
        Pattern pattern = Pattern.compile("^[A-Za-z ]+");
        Matcher matcher = pattern.matcher(studentName);
        if (isBlankOrNull(studentName)) {
            throw new IllegalArgumentException("StudentName can not be empty");
        } else if (!matcher.matches()) {
            throw new IllegalArgumentException("Name must not contains special characters: " + studentName);
        }
    }

    private void validate(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException("Number has to be between 1 and 5.");
        }
    }

    private boolean isBlankOrNull(String text) {
        return (text == null || text.isBlank());
    }

    public static void main(String[] args) {
        Diary diary = new Diary();

        diary.newMark("Jolan Valaki", 5);
        diary.average("Jolan Valaki");

    }
}
