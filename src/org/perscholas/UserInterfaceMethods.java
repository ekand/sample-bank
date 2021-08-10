package org.perscholas;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterfaceMethods {


    public static void userInterface(Accounts accounts) {

        BankAccount currentAccount;
        System.out.println("Welcome to Sample Bank. We hope you enjoy your stay!");

        boolean inMainMenu = true;
        while (inMainMenu) {
            System.out.println("======Main Menu:======\n" +
                    "  - 1 Create new account\n" +
                    "  - 2 Access Existing account\n" +
                    "  - 3 exit");
            Scanner scn = new Scanner(System.in);
            int userSelectionMainMenu = scn.nextInt();
            switch (userSelectionMainMenu) {
                case 1:
                    accounts.accounts.add(createNewAccount());
                    break;
                case 2:
                    currentAccount = connectToAccount(accounts.accounts);
                    if (currentAccount == null)  {
                        System.out.println("Account not found; returning to main menu");
                    } else {
                        interactWithAccount(currentAccount);
                    }
                    break;
                case 3:
                    inMainMenu = false;
                    break;
                case 99:
                    System.out.println(accounts);

            }


        }

    }

    private static BankAccount connectToAccount(ArrayList<BankAccount> accounts) {
        System.out.println("==Connecting to account menu==");
        System.out.println("Please enter your account number");
        Scanner scn = new Scanner(System.in);
        int userSelectionAccountId = scn.nextInt();
        for (BankAccount account : accounts) {
            if (account.id == userSelectionAccountId) {
                return account;
            }
        }
        return null;
    }

    private static BankAccount createNewAccount() {
        System.out.println("==New account menu==:\n" +
                "  - 1 Create checking account\n" +
                "  - 2 Create savings account");
        Scanner scn = new Scanner(System.in);
        int accountTypeCode = scn.nextInt();
        System.out.println("Please enter an account id");
        int accountId = scn.nextInt();
        // get account Type Code
        // get int id, int annualFee, int interestRate, int balance
        BankAccount bankAccount = BankAccount.createAccount(accountTypeCode, accountId);
        System.out.println("Account " + accountId + " created");
        return bankAccount;

    }



    private static boolean continueInteracting = true;




    private static void interactWithAccount(BankAccount currentAccount) {
        boolean inInteractWithAccount = true;
        while (inInteractWithAccount) {
            System.out.println("===Interacting with account menu=== \n" +
                    "1 - Deposit \n" +
                    "2 - Withdraw \n" +
                    "3 - Exit");

            Scanner scan = new Scanner(System.in);


            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How much do you want to deposit?");
                    int depositAmount = scan.nextInt();
                    currentAccount.deposit(depositAmount);
                    System.out.println("You have deposited " + depositAmount + "\n" +
                            "Your new balance is " + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.println("How much do you want to withdraw?");
                    int withdrawAmount = scan.nextInt();
                    currentAccount.withdraw(withdrawAmount);
                    System.out.println("You have withdrawn " + withdrawAmount + "\n" +
                            "Your new balance is " + currentAccount.getBalance());
                    break;
                case 3:
                    inInteractWithAccount = false;
                    break;
            }
        }
    }





}





