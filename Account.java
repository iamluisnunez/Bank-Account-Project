package com.kenzie.app;

import java.util.Locale;
import java.util.Random;

public class Account {
    //create class instance variables here
    private String userName;
    private String accountId;
    private double balance;

    //implement the following class constructors
    public Account(String userName) {
        this.userName = userName;
        //random number between 0-999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        //formatting the number
        String idNumber = String.format("%06d", number);
        this.accountId = userName.substring(0, 3).toLowerCase() + idNumber;
    }

    public Account(String userName, String accountId) {
        this.userName = userName;
        if (accountId.equals("")) {
            //random number between 0-999999
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            //formatting the number
            String idNumber = String.format("%06d", number);
            this.accountId = userName.substring(0, 3).toLowerCase() + idNumber;
        } else {
            this.accountId = accountId;
        }

    }
    public Account(String userName, double balance){
        this.userName = userName;
        this.balance = balance;
        //random number between 0-999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        //formatting the number
        String idNumber = String.format("%06d", number);
        this.accountId = userName.substring(0, 3).toLowerCase() + idNumber;
    }

    public Account(String userName, String accountId, double balance) {
        this.userName = userName;
        //random number between 0-999999
        if (accountId.equals("")) {
            //random number between 0-999999
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            //formatting the number
            String idNumber = String.format("%06d", number);
            this.accountId = userName.substring(0, 3).toLowerCase() + idNumber;
        } else {
            this.accountId = accountId;
        }
        this.balance = balance;
    }

    public String getUserName() {
        // return the user name of the current account
        return this.userName;
    }

    public String getAccountId() {
        // return the account id fo the current account
        return this.accountId;
    }

    public double getBalance() {
        // return the current balance of the account
        return this.balance;
    }

    public void makeDeposit(double amount) {
        // Add the given amount to the balance of the account
        this.balance = balance + amount;
    }

    public double makeWithdrawal(double amount) {
        // If the account has enough money, then withdraw the given amount
        // If the account does not have enough money, then return 0 and do not modify the balance
        // Otherwise return the amount that was withdrawn

        double balance = this.balance;

        if (getBalance() >= amount) {
            this.balance = balance - amount;
            return amount;
        }
        else{
            return 0;
        }
    }
}
