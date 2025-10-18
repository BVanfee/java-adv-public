package collectionsmap;

import java.util.Map;

public class Casting {

    /*Egy meghallgatáson sorszámot kapnak a jelentkezők,
    és a számok sorrendjében hívják be őket. Aki éppen nincs
    ott abban a pillanatban, amikor hívják, azt kihagyják és
    majd később foglalkoznak vele. Írd meg a Casting osztályban
    a String callNextApplicant(int lastNumber, Map<Integer, String> applicants)
    metódust, amely paraméterül várja az utolsóként behívott ember sorszámát,
    valamint a várakozó jelentkezőket egy Map-ben, ahol a kulcsok a sorszámok,
    az értékek pedig a jelentkezők nevei. A feladat az, hogy iterálj végig
    a Map kulcsain, és add vissza a sorban következő számmal rendelkező
    ember nevét! (Ha például a 77, 105, 19, 45 és 82 sorszámú emberek
    várakoznak éppen, és az utolsóként behívott jelentkező sorszáma 40
    volt, akkor a jelenlévők közül a 45-öst fogják behívni következőnek.)*/

    public String callNextApplicant(int lastNumber, Map<Integer, String> applicants) {
        int next = Integer.MAX_VALUE;
        for (Map.Entry<Integer, String> integerStringEntry : applicants.entrySet()) {
            if (integerStringEntry.getKey() < next && integerStringEntry.getKey() > lastNumber) {
                next = integerStringEntry.getKey();
            }
        }
        return applicants.get(next);
    }
}
