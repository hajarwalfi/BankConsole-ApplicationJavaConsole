package presentation;

import business.BankService;
import util.InputUtils;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final BankService bankService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bankService = new BankService(); // Service de gestion des comptes
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = InputUtils.readInt(scanner, "Entrez votre choix: ");

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        checkBalance();
                        break;
                    case 6:
                        viewAccountDetails();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Merci d'avoir utilisé l'application bancaire. Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Essayez encore.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Bank Management System ===");
        System.out.println("1. Créer un compte");
        System.out.println("2. Effectuer un versement dans un compte");
        System.out.println("3. Effectuer un retrait d'un compte");
        System.out.println("4. Effectuer un virement entre comptes");
        System.out.println("5. Consulter le solde du compte");
        System.out.println("6. Consulter la liste des opérations effectuées sur un compte");
        System.out.println("0. Quitter");
    }

    // ===== Menu Actions =====

    private void createAccount() {
        System.out.println("\nType de compte:");
        System.out.println("1. Compte Courant");
        System.out.println("2. Compte Épargne");
        int type = InputUtils.readInt(scanner,"Votre choix: ");

        String code = InputUtils.readString(scanner,"Entrez le code du compte (format CPT-XXXXX): ");
        double initialBalance = InputUtils.readDouble(scanner,"Solde initial: ");

        if (type == 1) {
            double overdraft = InputUtils.readDouble(scanner,"Découvert autorisé: ");
            bankService.createCheckingAccount(code, initialBalance, overdraft);
            System.out.println("Compte courant créé avec succès!");
        } else if (type == 2) {
            double interestRate = InputUtils.readDouble(scanner,"Taux d'intérêt (%): ");
            bankService.createSavingsAccount(code, initialBalance, interestRate);
            System.out.println("Compte épargne créé avec succès!");
        } else {
            System.out.println("Type de compte invalide.");
        }
    }

    private void deposit() {
        String code = InputUtils.readString(scanner,"Entrez le code du compte: ");
        double amount = InputUtils.readDouble(scanner,"Montant à déposer: ");
        String source = InputUtils.readString(scanner,"Source du dépôt: ");
        bankService.deposit(code, amount, source);
        System.out.println("Dépôt effectué avec succès!");
    }

    private void withdraw() {
        String code = InputUtils.readString(scanner,"Entrez le code du compte: ");
        double amount = InputUtils.readDouble(scanner,"Montant à retirer: ");
        String destination = InputUtils.readString(scanner,"Destination du retrait: ");
        bankService.withdraw(code, amount, destination);
        System.out.println("Retrait effectué avec succès!");
    }

    private void transfer() {
        String fromCode = InputUtils.readString(scanner,"Compte source: ");
        String toCode = InputUtils.readString(scanner,"Compte destinataire: ");
        double amount = InputUtils.readDouble(scanner,"Montant à transférer: ");
        bankService.transfer(fromCode, toCode, amount);
        System.out.println("Virement effectué avec succès!");
    }

    private void checkBalance() {
        String code = InputUtils.readString(scanner,"Entrez le code du compte: ");
        double balance = bankService.getBalance(code);
        System.out.println("Solde actuel: " + balance + " MAD");
    }

    private void viewAccountDetails() {
        String code = InputUtils.readString(scanner,"Entrez le code du compte: ");
        System.out.println(bankService.getAccountDetails(code));
    }

}
