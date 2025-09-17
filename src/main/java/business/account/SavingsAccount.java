package business.account;

import business.operation.*;
import util.ValidationUtils;

public class SavingsAccount extends Account{
    private final double interestRate;

    public SavingsAccount(String code, double initialBalance,double interestRate){
        super( code,initialBalance);
        ValidationUtils.validatePositiveAmount(interestRate);
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    @Override
    public void withdraw(double amount, String destination){
        ValidationUtils.validatePositiveAmount(amount);
        ValidationUtils.validateNotEmpty(destination,"Destination");

        if(this.balance >= amount) {
            Withdrawal withdrawal = new Withdrawal(amount, destination);
            this.balance -= amount;
            this.listOperation.add(withdrawal);
        }else{
            throw new IllegalArgumentException("Retrait refusé: solde insuffisant");
        }


    }

    @Override
    public double calculateInterest(){
        return balance*(interestRate/100.0);
    }

    @Override
    public String displayDetails(){
        StringBuilder details = new StringBuilder();
        details.append("Compte Epargne\n");
        details.append("Code:").append(this.code).append("\n");
        details.append("Solde:").append(this.balance).append("Mad\n");
        details.append("Taux d'interet: ").append(this.interestRate).append("%\n");
        details.append("Interet calculé: ").append(calculateInterest()).append(" MAD\n");
        details.append("Nombre d'opérations:").append(this.listOperation.size()).append("\n");
        if (!this.listOperation.isEmpty()){
            details.append("\n Dernieres opérations\n");
            for(Operation op:this.listOperation){
                details.append(op.toString()).append("\n");
            }
        }
        return details.toString();
    }
}
