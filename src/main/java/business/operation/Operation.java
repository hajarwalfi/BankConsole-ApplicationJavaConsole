package business.operation;

import java.time.LocalDate;
import java.util.UUID;
import util.ValidationUtils;

public abstract class Operation {
    protected final String id;
    protected LocalDate date;
    protected double amount;

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

    @Override
    public String toString(){
        return "Operation{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
    public abstract String getDetails();

}
