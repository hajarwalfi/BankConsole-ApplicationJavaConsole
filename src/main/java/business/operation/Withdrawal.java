package business.operation;

import util.ValidationUtils;

public class Withdrawal extends Operation  {
    private final String destination;

    public Withdrawal(double amount, String destination){
        super(amount);
        ValidationUtils.validateNotEmpty(destination,"Destination");
        this.destination = destination;
    }
    public String getDestination(){
        return destination;
    }
    @Override
    public String toString(){
        return super.toString()+ ", destination='"+destination+"'";
    }
    @Override
    public String getDetails() {
        return "Retrait de " + getAmount() + " MAD, Destination: " + destination + ", Date: " + getDate();
    }
}
