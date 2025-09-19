package util;

import business.account.Account;
import java.util.List;

public class ValidationUtils {

    public static void validatePositiveAmount(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Le montant doit être positif!");
        }
    }

    public static void validateNotEmpty(String value, String fieldName){
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }

    public static void validateAccountCode(String code){
        if(!code.matches("^CPT-\\d{5}$")){
            throw new IllegalArgumentException("Le code de compte doit respecter le format CPT-XXXXX (où X = chiffre)."
            );
        }
    }

    public static void validateAccountNotExists(List<Account> accounts, String code) {
        for (Account acc : accounts) {
            if (acc.getCode().equals(code)) {
                throw new IllegalArgumentException("Un compte avec ce code existe déjà: " + code
                );
            }
        }
    }

    public static void validateDifferentAccounts(String fromCode, String toCode) {
        if (fromCode.equals(toCode)) {
            throw new IllegalArgumentException("Impossible d'effectuer un virement sur le même compte."
            );
        }
    }

    public static String generateAccountCode() {
        return "CPT-" + (business.account.Account.counter++);
    }
}
