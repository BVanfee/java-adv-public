package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private static final int STANDARD_SIZE = 1000;
    private static final int STANDARD_PERIOD = 12;

    private double price;
    private PayPeriod period;
    private String provider;
    private int space;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }


    @Override
    public int compareTo(CloudStorage o) {
        double actualPrice = 0;
        double otherPrice = 0;
        if (this.period != null) {
            actualPrice = price * STANDARD_PERIOD / period.getLength() / this.space * STANDARD_SIZE;
        }
        if (o.getPeriod() != null) {
            otherPrice = o.getPrice() * STANDARD_PERIOD / o.getPeriod().getLength() / o.getSpace() * STANDARD_SIZE;
        }
        return Double.compare(actualPrice, otherPrice);
    }
}
