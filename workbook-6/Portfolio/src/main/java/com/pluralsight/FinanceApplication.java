package com.pluralsight;

import com.pluralsight.finance.*;


public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        IValuable account2 = new BankAccount("Gary", "456", 1500);
        Gold gold1 = new Gold("Chain", 1, 1.2);
        Jewelry jewelry1 = new Jewelry("Diamong Ring", 123, 44);
        // try to deposit money into both accounts
        account1.deposit(100);
       ((BankAccount) account2).deposit(100);

       Portfolio portfolio = new Portfolio("My Portfolio", "Joshua W.");
       portfolio.add(account1);
       portfolio.add(account2);
       portfolio.add(gold1);
       portfolio.add(jewelry1);

        System.out.println("Most valuable:" + portfolio.getMostValuable());
        System.out.println("Least valuable: "+ portfolio.getLeastValuable());
        System.out.println("Total value: "+ portfolio.getValue());
    }
}
