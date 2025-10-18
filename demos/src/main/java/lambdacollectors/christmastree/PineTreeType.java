package lambdacollectors.christmastree;

public enum PineTreeType {

    NORDMANN(10_000), SILVER(8_000), SPRUCE(4_000);

    private int price;

    PineTreeType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
