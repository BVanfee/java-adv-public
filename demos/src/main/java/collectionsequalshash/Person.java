package collectionsequalshash;

import java.util.Objects;

public class Person {

    /*Hozz létre egy Person osztályt,
    amelyben három attribútum legyen: név, életkor és TAJ-szám.
    Különböző élethelyzetekben az ember neve és életkora lehet más,
    de a TAJ-száma mindig ugyanaz. Írd felül az osztályban az equals()
    és hashCode() metódusokat úgy, hogy azok a TAJ-szám értékét vegyék
    figyelembe két személy összehasonlításakor! Próbáld ki az osztály
    main() metódusában a következőt: példányosíts két különböző
    Person objektumot, akiknek az adatai közül csak a TAJ-szám egyezzen meg!
    Hasonlítsd össze őket az equals() metódussal, és az eredményt írd ki a konzolra!
    Hívd meg mindkettőn a hashCode() metódust is, és ennek az eredményét is írd ki a konzolra!
     */

    private String name;
    private int age;
    private final String tajNumber;

    public Person(String name, int age, String tajNumber) {
        this.name = name;
        this.age = age;
        this.tajNumber = tajNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTajNumber() {
        return tajNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(tajNumber, person.tajNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tajNumber);
    }

    public static void main(String[] args) {
        Person valaki = new Person("Kovács Klára", 28, "223456789");
        Person valakimas = new Person("Péter Zsolt", 2, "113456789");
        Person mas = new Person("Adorján Zoltán", 30, "123456789");

        Person valakine = valaki;
        valaki.setName("Nagyné Klára");
        valaki.setAge(35);
        System.out.println(valaki.equals(mas));
        System.out.println(valaki.equals(valakimas));
        System.out.println(valaki.equals(valakine));

        System.out.println(valaki);
        System.out.println(mas);
        System.out.println(valakine);
        System.out.println(valakimas);
    }


}
