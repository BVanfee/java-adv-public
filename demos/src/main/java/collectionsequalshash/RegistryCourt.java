package collectionsequalshash;

import java.util.ArrayList;
import java.util.List;

public class RegistryCourt {

    public static void main(String[] args) {


        Company company1 = new Company("Boldogság Zrt.", "4646443");
        Company company2 = new Company("Jövő Bt", "46447843");
        Company company3 = new Company("MÁV Zrt.", "4655543");
        Company company4 = new Company("Szerencsejáték Zrt.", "4622243");

        List<Company> companies = new ArrayList<>();

        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        companies.add(company4);

        System.out.println(companies.contains(new Company("Boldogság Zrt.", "4646443")));
        System.out.println(companies.size());
    }

}
