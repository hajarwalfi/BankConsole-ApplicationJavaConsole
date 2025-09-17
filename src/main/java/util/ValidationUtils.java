package util;

import business.account.Account;
import java.util.Map;

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

    public static void validateAccountCode(String code){
        if(!code.matches("^CPT-\\d{5}$")){
            throw new IllegalArgumentException("le code de compte doit respecter le format CPT-XXXXX (où X = chiffre).");
        }
    }
    public static void validateAccountNotExists(Map<String, Account> accounts, String code) {
        if (accounts.containsKey(code)) {
            throw new IllegalArgumentException("Un compte avec ce code existe déjà: " + code);
        }
    }
    public static Account validateAccountExists(Map<String, Account> accounts, String code) {
        Account account = accounts.get(code);
        if (account == null) {
            throw new IllegalArgumentException("Aucun compte trouvé avec le code: " + code);
        }
        return account;
    }
    public static void validateDifferentAccounts(String fromCode, String toCode) {
        if (fromCode.equals(toCode)) {
            throw new IllegalArgumentException("Impossible d'effectuer un virement sur le même compte.");
        }
    }
}
