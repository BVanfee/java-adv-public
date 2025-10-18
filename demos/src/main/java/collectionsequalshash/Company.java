package collectionsequalshash;

import java.util.Objects;

public class Company {

    /*Legyen egy Company osztályod, amelynek két attribútuma: a cég neve és adószáma!
    Írd felül az osztályban az equals() és a hashCode() metódusokat úgy,
    hogy mindkét attribútum értékét figyelembe vegyék, vagyis két céget akkor
    tekintsünk megegyezőnek, ha a neve és az adószáma is megegyezik!
    Hozz létre egy RegistryCourt (cégbíróság) osztályt, amelynek main() metódusában
    készíts egy Company típusú elemeket tartalmazó listát!
    Példányosíts ezenkívül néhány céget, amelyeket adj a listához,
    majd írd ki a konzolra, hogy a lista tartalmaz-e ilyen elemeket.
    A következő módon csináld ezt:
     Például ha hozzáadod a listához ezt a céget: new Company("Cég Kft", "1234");,
     akkor így hívd meg a lista contains() metódusát: contains(new Company("Cég Kft", "1234"))!
     (A lista contains() metódusa az átadott elem equals() metódusát hívja,
     és az alapján keresi az adott elemet a listában.)*/

    private String name;
    private String number;

    public Company(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(number, company.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
