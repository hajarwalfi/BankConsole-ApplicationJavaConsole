package util;

public class ValidationUtils {
    public static void validatePositiveAmount(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("le montant doit etre positif!");
        }
    }
}
