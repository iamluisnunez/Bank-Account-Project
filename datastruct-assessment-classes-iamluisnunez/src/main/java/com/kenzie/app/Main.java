package com.kenzie.app;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void addMoneyToAccount(HashMap<String, Account> BankAccounts, Account accountToDeposit, double totalAmount) {

        accountToDeposit.makeDeposit(totalAmount);

    }

    public static void transferBetween(Account source, Account recipient, double amount) {
        // This method should attempt to withdraw the amount from the source account,
        // and deposit it into the recipient account.
        // If the source account does not have enough money, then neither account should be changed
        // Your Code Here
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
        //Vars
        HashMap<String, Account> BankAccounts = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String accountAnswer = "";
        String newUserName = "";
        double newAccountMoney = 0;
        int menuOptions = 0;
        //Welcome to Luis's ATM
        System.out.println("*** Welcome to Luis's ATM ***");

        // Create Three accounts
        System.out.println("Are you a new or existing Customer? (Yes / No)");
        //creating a new bank account is user is new
        accountAnswer = sc.nextLine().toLowerCase();
        if (accountAnswer.equals("yes")) {
            System.out.println("Enter a username below");
            newUserName = sc.nextLine();
            System.out.println("Would you like to add money to your new account?");
            String temp = sc.nextLine().toLowerCase();

            if (temp.equals("yes")) {
                System.out.println("How much would you like to add?");
                newAccountMoney = sc.nextDouble();
                Account newUserAccount = new Account(newUserName, newAccountMoney);
                BankAccounts.put(newUserName, newUserAccount);
                System.out.println("Here is your new account");
                System.out.println(BankAccounts.keySet() + " " + "&" + BankAccounts.get(newUserName).getBalance());
            } else if (temp.equals("no")) {
                System.out.println("You will start at $0.00");
                Account newUserAccount = new Account(newUserName, newAccountMoney);
                BankAccounts.put(newUserName, newUserAccount);
                System.out.println("Here is your new account");
                System.out.println(BankAccounts.keySet() + " " + "&" + BankAccounts.get(newUserName).getBalance());
            }
        } else if (accountAnswer.equals("no")) {
            //do nothing?
            System.out.println("Thanks for being a Customer of ours!");
        }
        System.out.println("Would you like to do anything else?");
        System.out.println("Press 1 for adding another account");
        System.out.println("Press 2 for making a deposit");
        System.out.println("Press 3 for making a withdrawl");
        System.out.println("Press 4 for transferring money within accounts");

        menuOptions = sc.nextInt();
        while(menuOptions != 1 || menuOptions != 2 || menuOptions != 3 || menuOptions != 4){
            System.out.println("Please enter a number for the following services.");
            System.out.println("Press 1 for adding another account");
            System.out.println("Press 2 for making a deposit");
            System.out.println("Press 3 for making a withdrawl");
            System.out.println("Press 4 for transferring money within accounts");
            menuOptions = sc.nextInt();
        }

        //add to account

        //withdrawl from account

        //transfer between accounts

        //check account (total money in account and basic info of the customer)

        //Show all users in the ATM (Admin access)





//            System.out.println(companyAccount.getUserName() + " - " + companyAccount.getAccountId() + " - " + companyAccount.getBalance());
//            // This should print: Kenzie - ken258192 - 10000.0
//            System.out.println(employee.getUserName() + " - " + employee.getAccountId() + " - " + employee.getBalance());
//            // This should print: JoeTheManager - joe528511 - 0.0
//            // The numbers of your ID will vary.
//            System.out.println(contractor.getUserName() + " - " + contractor.getAccountId() + " - " + contractor.getBalance());
//            // This should print: AnnaTheContractor - con250192 - 0.0
//
//            // Payout employee
//            transferBetween(companyAccount, employee, 1000);
//            System.out.println(employee.getUserName() + " - " + employee.getBalance());
//            // This should print: JoeTheManager - 1000.0
//            System.out.println(companyAccount.getUserName() + " - " + companyAccount.getBalance());
//            // This should print: Kenzie - 9000.0
//
//            // Employee Make Three payments to the contractor
//            transferBetween(employee, contractor, 400);
//            System.out.println(contractor.getUserName() + " - " + contractor.getBalance());
//            // This should print: AnnaTheContractor - 400.0
//            transferBetween(employee, contractor, 400);
//            System.out.println(contractor.getUserName() + " - " + contractor.getBalance());
//            // This should print: AnnaTheContractor - 800.0
//
//            // The last payment should fail because Joe doesn't have enough.
//            transferBetween(employee, contractor, 400);
//            System.out.println(contractor.getUserName() + " - " + contractor.getBalance());
//            // This should print: AnnaTheContractor - 800.0
//            System.out.println(employee.getUserName() + " - " + employee.getBalance());
//            // This should print: JoeTheManager - 200.0
        }
    }
