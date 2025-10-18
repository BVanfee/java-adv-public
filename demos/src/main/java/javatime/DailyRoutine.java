package javatime;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DailyRoutine {
    private static final int DURATION_OF_LESSON_IN_MINUTES = 45;
    private static final int NUMBER_OF_LESSONS = 3;
    private static final int DURATION_OF_BREAK_IN_MINUTES = 25;
    private static final int NUMBER_OF_BREAKS = 1;


    /*Phileas Fogg egy rendkívül precíz angol gentleman, aki a napjait percnyi
    pontossággal osztja be. Nyelvtanára sajnos nem ennyire pontos, minden
    délelőtt 9 óra körül kezdi az órákat, és három 45 perces nyelvórát tart
    egy 25 perces szünettel.

Fogg úr percre pontosan szeretné tudni, hogy mikor fogják befejezni,
és azt is, hogy be fogják-e fejezni déli 12 előtt az órákat. Segítsünk neki ebben!

Egy olyan osztályt - DailyRoutine - hozzunk létre, amelynek objektuma tárolja
a mindenkori órakezdetet percnyi pontossággal, és ki tudja számolni, mikor
fejeződik be az oktatás, valamint azt is meg tudja mondani, hogy ez még déli
12 óra előtt megtörténik-e.

Az osztály startTime attribútuma tárolja a nyelvórák kezdetét, ez megadható
óra és perc, de megadható standard szöveges formában is (hh:mm).

Megvalósítás
Az osztály objektumait többféle módon is létre lehessen hozni, számokkal
vagy akár szöveges dátum formátumból. Publikus metódusai segítségével a
tárolt időpont módosítható a befejezés időpontjára, és lekérdezhető,
hogy ez az időpont hogyan viszonyul a déli 12 órához, azt megelőzi-e.

publikus metódusok:

Copy Code
public DailyRoutine(int hour, int minute)
public DailyRoutine(String timeString)

public void setFutureTime(int minutes)
public boolean isBeforeNoon()
Tippek
Érdemes utánanézni a LocalTime osztály leírásának a Java dokumentációban,
 és megismerkedni az osztály által biztosított LocalTime.NOON final static értékkel.*/

    private LocalTime startTime;

    public DailyRoutine(int hour, int minute) {
        this.startTime = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String startTime) {
        if (startTime == null || startTime.isBlank()) {
            throw new IllegalArgumentException("StartTime can not be empty or null");
        }
        try {
            this.startTime = LocalTime.parse(startTime);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Wrong format, string has to be: hh:mm", e.getCause());
        }
    }

    public String endTime(){
        return getEndOfTheLesson().toString();
    }

    private LocalTime getEndOfTheLesson() {
        return startTime.plusMinutes(DURATION_OF_LESSON_IN_MINUTES * NUMBER_OF_LESSONS
                + DURATION_OF_BREAK_IN_MINUTES * NUMBER_OF_BREAKS);
    }

    public boolean isBeforeNoon(){
        return getEndOfTheLesson().isBefore(LocalTime.NOON);
    }

    public void setFutureTime(int minutes){
        this.startTime = startTime.plusMinutes(minutes);
    }
}
