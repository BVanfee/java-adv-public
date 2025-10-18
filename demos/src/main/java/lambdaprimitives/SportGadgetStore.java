package lambdaprimitives;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products
                .stream()
                .mapToInt(Product::getPieces)
                .sum();
    }

    public double getAveragePrice() {
        return products
                .stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stat = products
                .stream()
                .filter(x -> x.getPrice() > minPrice)
                .mapToInt(Product::getPieces)
                .summaryStatistics();
        String result = (stat.getCount() > 0) ? "Összesen " + stat.getCount() + " féle termék, " +
                "amelyekből minimum " + stat.getMin() + " db, maximum " + stat.getMax() + " db, " +
                "összesen " + stat.getSum() + " db van." : "Nincs ilyen termék.";
        return result;

    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }


}
