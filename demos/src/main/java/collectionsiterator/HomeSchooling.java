package collectionsiterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HomeSchooling {

    /*Készíts egy egyszerű alkalmazást, mellyel egy otthoni online tanulásra
    kényszerülő diák nyomon tudja követni, hogy mikor, melyik tanárral,
    milyen tanórája lesz. Legyen egy OnlineLesson osztály, amelynek három
    attribútuma van: a tanár neve, a tanóra címe és a tanóra kezdési időpontja!
    Mivel az otthoni online órák világa általában kaotikus és gyorsan változik,
    ezért szükség lesz néhány metódusra is. Ezekhez hozd létre a HomeSchooling osztályt,
    és következőket valósítsd meg: (Amit tudsz, azt iterátor használatával, amit nem, azt sima ciklussal.)

addNewLesson(OnlineLesson lesson): ezzel a diák új órát tud betenni az órarendjébe,
de fontos, hogy az időrendben a megfelelő helyre kerüljön be!
getLessonsByTitle(String title): ezzel le lehet kérni az összes ugyanolyan
típusú tanórát, pl. az összes matekórát.
removeLesson(LocalDateTime startTime): ezzel lehet kezdési időpont alapján tanórát törölni.
(Így a diák az olyan jellegű tanári e-mailekre tud reagálni, hogy
“Kedves Gyerekek! A pénteki első óra elmarad.”)*/

    private List<OnlineLesson> schedule = new ArrayList<>();

    public void addNewLesson(OnlineLesson lesson){
        int index = 0;
        for (OnlineLesson onlineLesson : schedule) {
            if(onlineLesson.getStartTime().isBefore(lesson.getStartTime())){
                index++;
            }
        }
        schedule.add(index,lesson);
    }

    public List<OnlineLesson> getLessonsByTitle(String title){
        List<OnlineLesson> lessons = new ArrayList<>();
        for (OnlineLesson onlineLesson : schedule) {
            if(onlineLesson.getLessonTitle().equals(title)){
                lessons.add(onlineLesson);
            }
        }
        return lessons;
    }

    public void removeLesson(LocalDateTime startTime){
        ListIterator<OnlineLesson> iterator = schedule.listIterator();

        while (iterator.hasNext()){
            OnlineLesson lesson = iterator.next();
            if(lesson.getStartTime().equals(startTime)){
                iterator.remove();
            }
        }

    }

    public List<OnlineLesson> getLessons() {
        return new ArrayList<>(schedule);
    }
}
