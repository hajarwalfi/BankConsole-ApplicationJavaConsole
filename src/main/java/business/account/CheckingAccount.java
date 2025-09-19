package business.account;

import business.operation.*;
import util.ValidationUtils;
import java.util.List;

public class CheckingAccount extends Account {
    private final double overdraft;

    public CheckingAccount(double initialBalance, double overdraft) {
        super(initialBalance);
        ValidationUtils.validatePositiveAmount(overdraft);
        this.overdraft = overdraft;
    }

    public double getOverdraft(){
        return overdraft;
    }

    @Override
    public void withdraw(double amount, String destination){
        ValidationUtils.validatePositiveAmount(amount);
        ValidationUtils.validateNotEmpty(destination,"Destination");
        if(this.balance - amount >= -this.overdraft) {
            Withdrawal withdrawal = new Withdrawal(amount, destination);
            this.balance -= amount;
            this.listOperation.add(withdrawal);
        } else {
            throw new IllegalArgumentException(
                    "Retrait refusé: découvert de " + overdraft + " dépassé"
            );
        }
    }

    @Override
    public double calculateInterest(){
        return 0;
    }

    @Override
    public String displayDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Compte Courant \n");
        details.append("code: ").append(this.code).append("\n");
        details.append("solde: ").append(this.balance).append(" MAD \n");
        details.append("découvert autorisé: ").append(this.overdraft).append(" MAD\n");
        details.append("nombre d'opérations: ").append(this.listOperation.size()).append("\n");
        if(!this.listOperation.isEmpty()){
            details.append("\nOpérations :\n");
            int i = 1;
            for (Operation op : this.listOperation){
                details.append(i++).append(". ").append(op.getDetails()).append("\n");
            }
        }
        return details.toString();
    }
}
