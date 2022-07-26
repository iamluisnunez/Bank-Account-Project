
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Account> createAccount(HashMap<String, Account> bankAccounts){
        Scanner sc = new Scanner(System.in);
        String accountAnswer = "";
        String newUserName = "";
        double newAccountMoney = 0;

        System.out.println("Are you a new or existing Customer? (New / Existing)");
        //creating a new bank account is user is new
        accountAnswer = sc.nextLine().toLowerCase();
        if (accountAnswer.equals("new")) {
            System.out.println("Enter a username below");
            newUserName = sc.nextLine();
            System.out.println("Would you like to add money to your new account? (Yes/ No)");
            String temp = sc.nextLine().toLowerCase();

            if (temp.equals("yes")) {
                System.out.println("How much would you like to add?");
                newAccountMoney = sc.nextDouble();
                Account newUserAccount = new Account(newUserName, newAccountMoney);
                bankAccounts.put(newUserName, newUserAccount);
                System.out.println("Here is your new account");
                System.out.println(bankAccounts.get(newUserName).getUserName());
            } else if (temp.equals("no")) {
                System.out.println("You will start at $0.00");
                Account newUserAccount = new Account(newUserName, newAccountMoney);
                bankAccounts.put(newUserName, newUserAccount);
                System.out.println("Here is your new account");
                //fix this 0 because it only prints the first name in the list
                System.out.println(bankAccounts.get(newUserName).getUserName());
            }
        } else if (accountAnswer.equals("no")) {
            //do nothing?
            System.out.println("Thanks for being a Customer of ours!");
        }
        return bankAccounts;
    }
    public static void addMoneyToAccount(Account account, double totalAmount) {
        account.makeDeposit(totalAmount);
    }

    public static void transferBetween(Account source, Account recipient, double amount) {

        double sourceBalance = source.getBalance();
        double recipientBalance = recipient.getBalance();
        String sourceName = source.getAccountId();
        String recipientName = recipient.getAccountId();

        if(sourceBalance > amount){
            source.makeWithdrawal(amount);
            recipient.makeDeposit(amount);
            System.out.println("Payment completed. Transferred " + amount + " from " + sourceName
                    + " to " + recipientName);
        }
        else{
            System.out.println("payment failed. Insufficient funds");
        }
    }

    public static void main(String[] args) {

        //Welcome to Luis's ATM
        System.out.println("*** Welcome to Luis's ATM ***");

        //Vars
        HashMap<String, Account> bankAccounts = new HashMap<>();
        int menuOptions = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println(createAccount(bankAccounts));

        boolean flag = true;
        while(flag) {
            System.out.println("Would you like to do anything else?");
            System.out.println("Press 1 for making a deposit");
            System.out.println("Press 2 for making a withdrawl");
            System.out.println("Press 3 for making another account");
            System.out.println("Enter 0 to exit");
            menuOptions = sc.nextInt();
            sc.nextLine();
            if(menuOptions == 0){
                flag = false;
                System.out.println("Total amount in account is " + bankAccounts.get(0).getBalance());
                System.out.println("Have a great day!");
                break;
            }
            switch (menuOptions) {
                case 1:
                    //method for depositing into account
                    System.out.println("What account would you like to deposit to?");
                    String account = sc.nextLine();

                    System.out.println("How much would you like to deposit?");
                    double amount = sc.nextDouble();

                    for (int i = 0; i < bankAccounts.size(); i++) {
                        if (bankAccounts.get(i).getUserName().equalsIgnoreCase(account)) {
                            bankAccounts.get(i).makeDeposit(amount);
                            System.out.println(amount + " was deposited into " + account + " for a total of " +
                                    bankAccounts.get(i).getBalance());
                        } else {
                            System.out.println("The account does not exist");
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    //method for making a withdrawl
                    System.out.println("What is your username?");
                    String accountWithdrawl = sc.nextLine();
                    System.out.println("How much would you like to deposit?");
                    double amountWithdrawl = sc.nextDouble();
                    for (int i = 0; i < bankAccounts.size(); i++) {
                        if (bankAccounts.get(i).getUserName().equalsIgnoreCase(accountWithdrawl)) {
                            bankAccounts.get(i).makeWithdrawal(amountWithdrawl);
                            System.out.println(amountWithdrawl + " was withdrawn from " + accountWithdrawl +
                                    " for a total of " + bankAccounts.get(i).getBalance());
                        } else {
                            System.out.println("The account does not exist");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter a username below");
                    String newUserName = sc.nextLine();
                    System.out.println("Would you like to add money to your new account? (Yes/ No)");
                    String temp = sc.nextLine().toLowerCase();

                    double newAccountMoney;
                    if (temp.equals("yes")) {
                        System.out.println("How much would you like to add?");
                        newAccountMoney = sc.nextDouble();
                        sc.nextLine();
                        Account newUserAccount = new Account(newUserName, newAccountMoney);
                        bankAccounts.put(newUserName, newUserAccount);
                        System.out.println("Here is your new account");
                        System.out.println(bankAccounts.get(newUserName).getUserName());
                    } else if (temp.equals("no")) {
                        System.out.println("You will start at $0.00");
                        Account newUserAccount = new Account(newUserName, 0);
                        bankAccounts.put(newUserName, newUserAccount);
                        System.out.println("Here is your new account");
                        //fix this 0 because it only prints the first name in the list
                        System.out.println(bankAccounts.get(newUserName).getUserName());
                    }
                    break;
                case 4:
                    for (Account name: bankAccounts.values()) {
                        String key = name.toString();
                        String value = bankAccounts.get(name).toString();
                        System.out.println(key + " " + value);
                    }
                    break;
            }
        }
    }
}

