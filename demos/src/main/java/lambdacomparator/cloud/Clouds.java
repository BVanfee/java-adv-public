package lambdacomparator.cloud;

import java.util.*;
import java.util.stream.Collectors;

public class Clouds {
    /*A Clouds osztály metódusai a paraméterként kapott listából bizonyos
    szempont szerint a legjobba(ka)t adják vissza. Amennyiben több ugyanolyan
    van, akkor közülük bármelyik visszaadható.

alphabeticallyFirst(): a szolgáltató neve alapján betűrendben a legelső
CloudStorage. Kis-nagybetű nem számít.

bestPriceForShortestPeriod(): a legrövidebb időszakra vonatkozó legolcsóbb
CloudStorage. Ha van ingyenes, akkor azok közül bármelyik megadható.

List<CloudStorage> worstOffers(): a természetes rendezettség szerinti 3
legrosszabb ajánlat.*/




    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        return Collections.min(storages,Comparator.comparing(CloudStorage::getProvider,
                (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase())));

    }


    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        return Collections.min(storages, Comparator.comparing(CloudStorage::getPeriod,
                Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).
                        thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        return storages
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }
}
