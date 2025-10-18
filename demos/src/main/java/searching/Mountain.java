package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mountain {
    /*Készíts egy Peak nevű osztályt két attribútummal: a hegycsúcs neve és magassága!
    Majd készíts egy Mountain nevű osztályt, melynek van egy olyan tömb attribútuma,
    amely csak a csúcsok magasságait tartalmazza, növekvő sorrendben! Legyen az
    osztályban egy boolean searchPeak(Peak peak) metódus, amely bináris kereséssel megkeresi,
     hogy a paraméterül átadott hegycsúcs magassága benne van-e a tömbben!*/

    private int[] peakHeights;


    public Mountain(int[] peakHeights) {
        this.peakHeights = peakHeights;
        Arrays.sort(peakHeights);
    }


    public boolean searchPeak(Peak peak) {
        return Arrays.binarySearch(peakHeights,peak.getHeight()) >= 0;
    }
}
