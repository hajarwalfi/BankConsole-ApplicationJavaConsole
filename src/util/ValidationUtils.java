package util;

public class ValidationUtils {
    public static void validatePositiveAmount(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("le montant doit etre positif!");
        }
    }
    public static void validateNotEmpty(String value, String fieldName){
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException(fieldName + "cannot be empty");
        }
    }
}
