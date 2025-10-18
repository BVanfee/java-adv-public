package optional;

public class Destination {

    /*Hozd létre a Destination osztályt, amelynek attribútumai legyenek:
    String name, String description, int kmFromHome! Majd hozd létre a
    BucketList osztályt, melynek legyen egy listája az úticélokkal!
    Az osztály Optional<Destination> getDestinationWithKeyword(String keyword)
    metódusa adja vissza az első úticélt a listából, amelynek leírásában szerepel
    a paraméterként megadott kulcsszó! A Optional<Destination> getDestinationNearerThanGiven(int maxKm)
    metódus pedig adja vissza az első olyan úticélt a listából, amely a
    paraméterként megadott kilométernél közelebb van!*/

    private String name;
    private String description;
    private int kmFromHome;

    public Destination(String name, String description, int kmFromHome) {
        this.name = name;
        this.description = description;
        this.kmFromHome = kmFromHome;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getKmFromHome() {
        return kmFromHome;
    }
}
