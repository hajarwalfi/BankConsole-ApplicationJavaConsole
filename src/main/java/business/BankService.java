package business;

import business.account.*;
import util.ValidationUtils;
import java.util.*;

public class BankService {
    private final Map<String, Account> accounts;

    public BankService() {
        this.accounts = new HashMap<>();
    }

    public CheckingAccount createCheckingAccount(String code, double initialBalance, double overdraft) {
        ValidationUtils.validateAccountCode(code);
        ValidationUtils.validateAccountNotExists(accounts, code);
        CheckingAccount account = new CheckingAccount(code, initialBalance, overdraft);
        accounts.put(code, account);
        return account;
    }

    public SavingsAccount createSavingsAccount(String code, double initialBalance, double interestRate) {
        ValidationUtils.validateAccountCode(code);
        ValidationUtils.validateAccountNotExists(accounts, code);
        SavingsAccount account = new SavingsAccount(code, initialBalance, interestRate);
        accounts.put(code, account);
        return account;
    }

    public Account getAccount(String code){
        ValidationUtils.validateAccountCode(code);
        return ValidationUtils.validateAccountExists(accounts, code);
    }

    public void deposit(String accountCode,double amount, String source){
        Account account = getAccount(accountCode);
        account.deposit(amount,source);
    }

    public void withdraw(String accountCode,double amount,String destination){
        Account account= getAccount(accountCode);
        account.withdraw(amount,destination);
    }

    public void transfer(String fromAccountCode,String toAccountCode,double amount){
        ValidationUtils.validateDifferentAccounts(fromAccountCode, toAccountCode);
        Account fromAccount=getAccount(fromAccountCode);
        Account toAccount=getAccount(toAccountCode);
        fromAccount.withdraw(amount,"Virement vers "+ toAccountCode);
        toAccount.deposit(amount,"Virement de "+fromAccountCode);
    }

    public double getBalance(String accountCode){
        return getAccount(accountCode).getBalance();
    }

    public String getAccountDetails(String accountCode) {
        return getAccount(accountCode).displayDetails();
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}

