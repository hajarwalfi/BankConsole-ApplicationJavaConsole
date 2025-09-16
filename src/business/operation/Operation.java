package business.operation;

import java.time.LocalDate;
import java.util.UUID;
import util.ValidationUtils;

public abstract class Operation {
    //final because the property shouldn't be reassigned after initializing, once it's set it cannot be changed
    //private because I don't want children modifying these directly
    private final String id;
    private final LocalDate date;
    private final double amount;

    protected Operation(double amount){
        ValidationUtils.validatePositiveAmount(amount);
        this.id= UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.amount = amount;
    }
    public String getId(){
        return id;
    }
    public LocalDate getDate(){
        return date;
    }
    public double getAmount(){
        return amount;
    }

    public String toString(){
        return "Operation{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

}
