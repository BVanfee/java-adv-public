package collectionscomp;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Building implements Comparable<Building> {
    /*Készíts egy Building osztályt, melynek három attribútuma a címe (String),
    az alapterülete és a szintjeinek száma! Az osztály implementálja a
    Comparable interfészt, és az osztályból készült objektumok legyenek összehasonlíthatóak
    a szintek száma alapján!
    Mivel a compareTo() és az equals() metódus által visszaadott értékek összefüggenek,
    ezért írd felül az osztály equals() és hashCode() metódusát is, hogy ugyanúgy
    a szintek számát vegyék figyelembe! Írd felül az osztályban a toString() metódust is!
    Majd ezután az osztály main() metódusában példányosíts egy Building
    objektumokat tartalmazó TreeSet-et, amelyhez adj hozzá több különböző szintszámú épületet!
    Végül írd ki ezt a kollekciót a konzolra, és nézd meg, hogy a benne szereplő
    épületek szintszám szerinti növekvő sorrendben fognak a konzolon szerepelni!*/

    private String address;
    private int area;
    private int floors;

    public Building(String address, int area, int floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return area == building.area && floors == building.floors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, floors);
    }

    @Override
    public int compareTo(Building o) {
        if (this.floors == o.getFloors()) {
            return this.area - o.getArea();
        } else {
            return this.floors - o.getFloors();
        }
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", floors=" + floors +
                '}';
    }

    public static void main(String[] args) {
        Set<Building> buildings = new TreeSet<>();

        buildings.add(new Building("Valahol utca 4", 250, 2));
        buildings.add(new Building("Fő utca 8", 800, 7));
        buildings.add(new Building("Király utca 15", 80, 1));
        buildings.add(new Building("Pillangó utca 53", 75, 1));
        buildings.add(new Building("Pillangó utca 51", 75, 1));
        buildings.add(new Building("Késmárki utca 9", 350, 3));
        buildings.add(new Building("Lengyel utca 15", 500, 5));

        System.out.println(buildings);
    }
}

