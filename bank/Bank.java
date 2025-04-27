package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Account createAccount(String accNo, String ownerName) {
        Account newAccount = new Account(accNo, ownerName);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccount(String accNo) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accNo)) {
                return account;
            }
        }
        return null;
    }

    public void depositTo(String accNo, double amount) {
        Account account = findAccount(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        try {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount + " to account " + accNo);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void withdrawFrom(String accNo, double amount) {
        Account account = findAccount(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        try {
            account.withdraw(amount);
            System.out.println("Successfully withdrew $" + amount + " from account " + accNo);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewBalance(String accNo) {
        Account account = findAccount(accNo);
        if (account == null) {
            System.out.println("Error: Account not found");
            return;
        }
        
        System.out.println("\nAccount Balance Details:");
        System.out.println("-------------------------------------------");
        System.out.printf("%-15s %-20s %s\n", "Account No", "Owner Name", "Balance");
        System.out.println("-------------------------------------------");
        System.out.printf("%-15s %-20s $%.2f\n", 
            account.getAccountNumber(), 
            account.getOwnerName(), 
            account.getBalance());
        System.out.println("-------------------------------------------");
    }
    
    public void printAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }
        
        System.out.println("\nAll Bank Accounts:");
        System.out.println("-------------------------------------------");
        System.out.printf("%-15s %-20s %s\n", "Account No", "Owner Name", "Balance");
        System.out.println("-------------------------------------------");
        
        for (Account account : accounts) {
            System.out.printf("%-15s %-20s $%.2f\n", 
                account.getAccountNumber(), 
                account.getOwnerName(), 
                account.getBalance());
        }
        System.out.println("-------------------------------------------");
    }
}