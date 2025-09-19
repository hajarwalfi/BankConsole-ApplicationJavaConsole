package business.operation;

import util.ValidationUtils;

public class Deposit extends Operation {
    private final String source;
    public Deposit(double amount , String source){
        super(amount);
        ValidationUtils.validateNotEmpty(source,"Source");
        this.source = source;
    }
    public String getSource(){
        return source;
    }
    @Override
    public String toString(){
        return super.toString()+", source='"+source +"'";
    }
    @Override
    public String getDetails() {
        return "Versement de " + getAmount() + " MAD, Source: " + source + ", Date: " + getDate();
    }
}
