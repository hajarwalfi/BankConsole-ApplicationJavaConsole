package presentation;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.print("\nBank Management System\n");
        System.out.print("1. Créer un compte;\n");
        System.out.print("2. Effectuer un versement dans un compte;\n");
        System.out.print("3. Effectuer un retrait d'un compte;\n");
        System.out.print("4. Effectuer un virement entre comptes;\n");
        System.out.print("5. Consulter le solde du compte;\n");
        System.out.print("6. Consulter la liste des opérations effectuées sur un compte;\n");
        System.out.print("0. exit\n");

        System.out.print("Entrez votre choix: ");
        int choice = scanner.nextInt();
    }
}
