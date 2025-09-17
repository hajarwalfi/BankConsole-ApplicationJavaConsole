package business.account;

import business.operation.*;
import util.ValidationUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected final String code;
    protected double balance;
    protected final List<Operation> listOperation;

    public Account(String code, double initialBalance){
        ValidationUtils.validateAccountCode(code);
        ValidationUtils.validatePositiveAmount(initialBalance);
        this.code = code;
        this.balance = initialBalance;
        this.listOperation = new ArrayList<>();
    }
    public String getCode(){
        return code;
    }
    public double getBalance(){
        return balance;
    }
    public List<Operation> getListOperation(){
        return new ArrayList<> (listOperation);
    }

    public void deposit(double amount, String source){
        ValidationUtils.validatePositiveAmount(amount);
        ValidationUtils.validateNotEmpty(source,"Source");

        Deposit deposit = new Deposit(amount, source);
        this.balance +=amount;
        this.listOperation.add(deposit);
    }
    public abstract void withdraw(double amount, String destination);
    public abstract double calculateInterest();
    public abstract String displayDetails();
}