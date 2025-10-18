package lambdaprimitives;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Truck {

    private List<Cargo> cargoList;

    public Truck(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public double getShortestLength() {
        return cargoList
                .stream()
                .mapToDouble(Cargo::getLength)
                .min()
                .orElse(0.0);
    }

    public int getTotalWeight() {
        return cargoList
                .stream()
                .mapToInt(Cargo::getWeight)
                .sum();
    }

    public double getAverageWeight() {
        return cargoList
                .stream()
                .mapToDouble(Cargo::getWeight)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No cargo."));

    }

    public int getMaxWeight() {
        return cargoList
                .stream()
                .mapToInt(Cargo::getWeight)
                .max()
                .orElse(0);
    }

    public String getWeightStatistics() {
        IntSummaryStatistics stat = cargoList
                .stream()
                .mapToInt(Cargo::getWeight)
                .summaryStatistics();

        return (stat.getCount() > 0)
                ? "A rakományban található " + stat.getCount() + " tétel, melyeknek " +
                "összsúlya " + stat.getSum() + " kg, közülük a legnehezebb " +
                stat.getMax() + " kg, a legkönnyebb " + stat.getMin() + " kg. " +
                "A súlyuk átlagosan " + stat.getAverage() + " kg."
                : "No cargo.";

    }

    public List<Cargo> getCargoList() {
        return new ArrayList<>(cargoList);
    }
}
