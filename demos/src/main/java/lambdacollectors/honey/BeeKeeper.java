package lambdacollectors.honey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeeKeeper {

    private List<Honey> honeyList;

    public BeeKeeper(List<Honey> honeyList) {
        this.honeyList = honeyList;
    }

    public int getTotalValueOfGivenGlasses(GlassSize size) {
        return (int) honeyList
                .stream()
                .filter(honey -> honey.getSize() == size)
                .collect(Collectors.summarizingDouble(Honey::getPrice))
                .getSum();
    }

    public Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type) {
        return honeyList
                .stream()
                .filter(honey -> honey.getType() == type)
                .collect(
                        Collectors.groupingBy(
                                Honey::getSize,
                                Collectors.counting()));
    }

    public Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size) {
        return honeyList
                .stream()
                .collect(Collectors
                        .partitioningBy(honey ->
                                honey.getType() == type &&
                                        honey.getSize() == size));
    }

    public void addHoney(Honey honey) {
        honeyList.add(honey);
    }

    public List<Honey> getHoneyList() {
        return new ArrayList<>(honeyList);
    }
}
