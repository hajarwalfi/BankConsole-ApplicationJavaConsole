# BankConsole Application

![Java](https://img.shields.io/badge/Java-8-orange?style=for-the-badge&logo=java&logoColor=white)

## Description du projet

Cette application console de gestion bancaire est développée en **Java 8**.  
Elle permet de gérer différents types de comptes bancaires et leurs opérations associées (versements, retraits, virements).  
L'application offre une interface intuitive en ligne de commande pour :

- Créer des comptes (courant ou épargne)
- Effectuer des opérations sur les comptes
- Consulter les soldes et l'historique des opérations

---

## Fonctionnalités principales

- **Création de comptes** : 
  - Compte courant (avec découvert autorisé)
  - Compte épargne (avec taux d'intérêt)
- **Gestion des opérations** : 
  - Versements
  - Retraits
  - Virements entre comptes
- **Consultation** : 
  - Solde des comptes
  - Historique détaillé des opérations
- **Validation des données** : 
  - Montants positifs
  - Format des codes de compte : `CPT-XXXXX`
  - Gestion des erreurs et messages explicites
- **Génération automatique** :
  - Codes de compte uniques
  - Identifiants d'opérations via UUID
  - Horodatage automatique des opérations

---

## Technologies utilisées

- **Langage** : Java 8+
- **Architecture** : Programmation Orientée Objet (POO)
- **Patterns de conception** :
  - Abstract Factory (création de comptes)
  - Template Method (classes abstraites)
  - Strategy (stratégies de retrait)
- **Collections Java** : ArrayList, HashMap
- **Validation** : Expressions régulières et règles métier
- **Identifiants uniques** : UUID
- **Gestion des dates** : Java Time API
- **Exceptions** : try/catch pour la robustesse des opérations

---

## Structure du projet

```

src/
└── main/
   └── java/
      ├── business/
       │   ├── BankService.java
       │   ├── account/
       │   │   ├── Account.java
       │   │   ├── CheckingAccount.java
       │   │   └── SavingsAccount.java
       │   └── operation/
       │       ├── Operation.java
       │       ├── Deposit.java
       │       └── Withdrawal.java
       ├── presentation/
       │   ├── Main.java
       │   └── Menu.java
       └── util/
           ├── InputUtils.java
           └── ValidationUtils.java


````

---

## Prérequis

- **Java Development Kit (JDK)** : Version 8 ou supérieure
- **IDE recommandé** : IntelliJ IDEA, Eclipse ou VS Code
- **Système d'exploitation** : Windows, macOS ou Linux

---

## Installation et exécution

### Vérifier l'installation de Java

```bash
java -version
javac -version
````

### Cloner le projet

```bash
git clone https://github.com/hajarwalfi/BankConsole-ApplicationJavaConsole.git
cd BankConsole-ApplicationJavaConsole
```

### Compilation

```bash
javac -d out -cp src src/main/java/presentation/Main.java
```

### Exécution

```bash
java -cp out presentation.Main
```

---

## Menu principal

```
=== Bank Management System ===
1. Créer un compte
2. Effectuer un versement dans un compte
3. Effectuer un retrait d'un compte
4. Effectuer un virement entre comptes
5. Consulter le solde du compte
6. Consulter la liste des opérations effectuées sur un compte
0. Quitter
```


## Extensibilité

L'architecture modulaire permet d'ajouter facilement :

* Nouveaux types de comptes (héritage de `Account`)
* Nouvelles opérations (héritage de `Operation`)
* Nouvelles validations (`ValidationUtils`)
* Interface graphique (remplacement de la couche `presentation`)

---

## Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

