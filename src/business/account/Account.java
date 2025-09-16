package business.account;

import business.operation.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String code;
    protected double balance;
    protected final List<Operation> listOperation;

    public Account(String code, double initialBalance){
        this.code = code;
        this.balance = initialBalance;
        this.listOperation = new ArrayList<>();
    }

    public abstract boolean withdraw(double amount);
    public abstract double calculateInterest();
    public abstract void displayDetails();
}