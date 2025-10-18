package iodatastream.bank;

public class BankAccount {
    /*Az iodatastream.bank csomagba készítsd el a BankAccount osztályt,
    melyben attribútumként a számlaszám (String), a tulajdonos neve (String)
     és az egyenleg (double) szerepel! A konstruktor mindhárom attribútumot
      várja, valamint mindegyikhez van getter.

Készíts egy BankAccountManager osztályt, melyben csak 2 metódus van.
 A saveAccount() metódus egy BankAccount példány állapotát menti a
 bankszámla számával megegyező nevű .dat kiterjesztésű fájlba DataOutputStream
 segítségével. Paraméterként megkapja a mentési mappát is Path objektumknt.
 A loadAccount() ugyanilyen szerkezetű fájlból betölti egy BankAccount adatait,
  és paraméterként csak egy InputStream-et vár.

A fájl minden adatot tartalmazzon az alábbi sorrendben: számlaszám, tulajdonos
neve, egyenleg!*/
    private String accountNumber;
    private String name;
    private double balance;

    public BankAccount(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
