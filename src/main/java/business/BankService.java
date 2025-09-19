package business;

import business.account.*;
import util.ValidationUtils;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private final List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public CheckingAccount createCheckingAccount(double initialBalance, double overdraft) {
        CheckingAccount account = new CheckingAccount(initialBalance, overdraft);
        accounts.add(account);
        return account;
    }

    public SavingsAccount createSavingsAccount(double initialBalance, double interestRate) {
        SavingsAccount account = new SavingsAccount(initialBalance, interestRate);
        accounts.add(account);
        return account;
    }

    public Account getAccount(String code){
        ValidationUtils.validateAccountCode(code);
        for (Account acc : accounts) {
            if (acc.getCode().equals(code)) {
                return acc;
            }
        }
        throw new IllegalArgumentException("Aucun compte trouvé avec le code: " + code);
    }

    public void deposit(String accountCode, double amount, String source){
        Account account = getAccount(accountCode);
        account.deposit(amount, source);
    }

    public void withdraw(String accountCode, double amount, String destination){
        Account account = getAccount(accountCode);
        account.withdraw(amount, destination);
    }

    public void transfer(String fromAccountCode, String toAccountCode, double amount){
        ValidationUtils.validateDifferentAccounts(fromAccountCode, toAccountCode);
        Account fromAccount = getAccount(fromAccountCode);
        Account toAccount = getAccount(toAccountCode);
        fromAccount.withdraw(amount, "Virement vers " + toAccountCode);
        toAccount.deposit(amount, "Virement de " + fromAccountCode);
    }

    public double getBalance(String accountCode){
        return getAccount(accountCode).getBalance();
    }

    public String getAccountDetails(String accountCode) {
        return getAccount(accountCode).displayDetails();
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}
