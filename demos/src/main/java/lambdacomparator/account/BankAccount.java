package lambdacomparator.account;

public class BankAccount implements Comparable<BankAccount> {

    /*Készíts egy account.BankAccount osztályt accountNumber, nameOfOwner és balance attribútumokkal!
     Az osztály implementálja a Comparable interfészt, és a compareTo metódus definiáljon egy
     természetes rendezettséget az osztály számára a számlaszámok alapján! Készíts egy account.
     BankAccounts osztályt, mely konstruktorban BankAccount listát vár.

Az osztály metódusai rendre új listát készítenek, rendezik a következő szabályok alapján,
és a rendezett listát adják vissza:

listBankAccountsByAccountNumber(): Rendezés bankszámlaszám alapján.
listBankAccountsByBalance(): Rendezés rendelkezésre álló összeg alapján, de előjeltől függetlenül.
listBankAccountsByBalanceDesc(): Rendezés rendelkezésre álló összeg alapján, az előjel számítson, de csökkenő sorrendben!
listBankAccountsByNameThenAccountNumber(): Rendezés név alapján, de ha a név megegyezik, akkor bankszámlaszám alapján.
Amennyiben nincs kitöltve a név (értéke null), elöl szerepeljen!
Kizárólag lambda kifejezéseket vagy method reference-eket használj!

Használd a következő metódusokat (persze a megfelelő paraméterezéssel): Comparator.naturalOrder(), Comparator.comparing(), Comparator.reversed(), Comparator.nullsFirst(), Comparator.thenComparing()!*/

    private String nameOfOwner;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, String nameOfOwner, double balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(BankAccount other) {
        return this.accountNumber.compareTo(other.getAccountNumber());
    }
}
