package com.pluralsight;

import com.pluralsight.finance.*;


public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        IValuable account2 = new BankAccount("Gary", "456", 1500);
        // try to deposit money into both accounts
        account1.deposit(100);
       // account2.deposit(100);
    }
}
