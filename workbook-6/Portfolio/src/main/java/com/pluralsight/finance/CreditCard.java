package com.pluralsight.finance;

public class CreditCard implements IValuable{
    /*---------------VARIABLES---------------*/

    private String name;
    private String accountNumber;
    private double balance;

    /*--------------CONSTRUCTORS-------------*/

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*---------------FUNCTIONS---------------*/

    public void charge(double amount){
        balance += amount;
    }

    public void pay(double amount){
        balance -= amount;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
