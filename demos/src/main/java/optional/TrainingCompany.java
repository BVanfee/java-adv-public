package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainingCompany {
    /*Egy felnőttképző cég mindenféle témájú tanfolyamokat kínál. Ennek
    modellezésére hozd létre a Course osztályt, amelynek attribútumai a
    tanfolyam neve, szintje és az ára! Ez utóbbi egy Level nevű enum az
    alábbi példányokkal: BEGINNER, ADVANCED, EXPERT. Majd hozz létre egy
    TrainingCompany osztályt, amely a kurzusok listáját kezeli. Ebben az
    osztályban írd meg a következő metódusokat:

Course getCheaperCourse(int maxPrice): visszaad egy olyan kurzust, amely
legfeljebb annyiba kerül, mint a megadott ár. Ha nem talál ilyet, kivételt
dob (ennek üzenetét megtalálod a tesztben).
int getPriceOfCourseWithGivenNameAndLevel(String name, Level level): megmondja
annak a kurzusnak az árát, amelynek a neve és a szintje megegyezik a paraméterül
átadott értékekkel. Ha nem talál ilyet, kivételt dob.
String getNameOfCourseWithGivenLevel(Level level): visszaadja egy kurzus nevét,
amelyik a megadottnak megfelelő szintű. Ha nem talál ilyet, visszaadja azt a
szöveget, hogy "Sorry, there is no course at this level."
Bár ezek a metódusok implementálhatóak Optional használata nélkül is, most
azonban kifejezetten az a cél, hogy úgy írd meg őket, hogy közben használod
az Optional osztály most megismert metódusait! Példányosíts egy Optional-t
és tedd bele a keresés eredményét! Majd úgy térj vissza a metódusokból, hogy
közben használd az orElse() vagy az orElseThrow() metódusok valamelyikét!*/

    private List<Course> courses;

    public TrainingCompany(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCheaperCourse(int maxPrice) {
        Optional<Course> cheapestThanMaxPriceCourse = Optional.empty();
        for (Course course : courses) {
            if (course.getPrice() < maxPrice) {
                cheapestThanMaxPriceCourse = Optional.of(course);
            }
        }
        return cheapestThanMaxPriceCourse.orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    public int getPriceOfCourseWithGivenNameAndLevel(String name, Level level) {
        Optional<Course> courseWithGivenNameAndLevel = Optional.empty();
        for (Course course : courses) {
            if (course.getName().equals(name) && course.getLevel() == level) {
                courseWithGivenNameAndLevel = Optional.of(course);
            }
        }
        return courseWithGivenNameAndLevel.orElseThrow(() -> new IllegalArgumentException("No such course.")).getPrice();
    }


    public String getNameOfCourseWithGivenLevel(Level level) {
        Optional<String> courseWithGivenLevel = Optional.empty();
        for (Course course : courses) {
            if (course.getLevel() == level) {
                courseWithGivenLevel = Optional.of(course.getName());
            }
        }
        return courseWithGivenLevel.orElse("Sorry, there is no course at this level.");
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
}
