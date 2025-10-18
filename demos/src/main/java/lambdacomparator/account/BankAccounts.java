package lambdacomparator.account;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber(){
        return bankAccounts
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    public List<BankAccount> listBankAccountsByBalance() {
        return bankAccounts
                .stream()
                .sorted(Comparator.comparingDouble(
                        accounts -> Math.abs(accounts.getBalance())))
                .collect(Collectors.toList());
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        return bankAccounts
                .stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance
                        ).reversed())
                .collect(Collectors.toList());
    }

    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        return bankAccounts
                .stream()
                .sorted(Comparator.comparing(BankAccount::getNameOfOwner,
                                Comparator.nullsFirst(Collator.getInstance(new Locale("hu", "HU"))))
                        .thenComparing(BankAccount::getAccountNumber))
                .collect(Collectors.toList());
    }
}
