package collectionsset;

public class Student {
    /*Hozz létre egy Student osztályt, amelynek két attribútuma legyen:
    a diák neve és centiméterekben mért magassága!
    Majd legyen egy PhysicalEducation osztály,
    amelyben egy Set<Integer> getHeightsInOrder(List<Student>) metódus,
    amely egy TreeSet-ben adja vissza a diákok magasságait,
    így érve el, hogy azok növekvő sorrendben legyenek!
    Az osztály main() metódusában írd is ki a visszakapott
    értéket a konzolra és ellenőrizd, hogy tényleg növekvő sorrendben vannak-e a számok!*/

    private String name;
    private int height;

    public Student(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
