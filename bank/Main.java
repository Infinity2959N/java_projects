package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Bank Account Management System");

        try {
            while (running) {
                System.out.println("\nPlease choose an option:");
                System.out.println("1) Create Account");
                System.out.println("2) Deposit");
                System.out.println("3) Withdraw");
                System.out.println("4) View Account Balance");
                System.out.println("5) List All Accounts");
                System.out.println("6) Exit");
                System.out.print("Enter your choice: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter account number: ");
                            String accNo = scanner.nextLine();
                            System.out.print("Enter owner name: ");
                            String ownerName = scanner.nextLine();

                            try {
                                bank.createAccount(accNo, ownerName);
                                System.out.println("Account created successfully for " + ownerName +
                                        " with account number: " + accNo);
                            } catch (Exception e) {
                                System.out.println("Error creating account: " + e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.print("Enter account number: ");
                            String depositAccNo = scanner.nextLine();
                            System.out.print("Enter amount to deposit: ");

                            try {
                                double depositAmount = scanner.nextDouble();
                                scanner.nextLine(); // Consume the newline
                                bank.depositTo(depositAccNo, depositAmount);
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Clear the scanner buffer
                            } catch (Exception e) {
                                System.out.println("Error: An unexpected error occurred: " + e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.print("Enter account number: ");
                            String withdrawAccNo = scanner.nextLine();
                            System.out.print("Enter amount to withdraw: ");

                            try {
                                double withdrawAmount = scanner.nextDouble();
                                scanner.nextLine(); // Consume the newline
                                bank.withdrawFrom(withdrawAccNo, withdrawAmount);
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Clear the scanner buffer
                            } catch (Exception e) {
                                System.out.println("Error: An unexpected error occurred: " + e.getMessage());
                            }
                            break;

                        case 4:
                            System.out.print("Enter account number: ");
                            String balanceAccNo = scanner.nextLine();
                            try {
                                bank.viewBalance(balanceAccNo);
                            } catch (Exception e) {
                                System.out.println("Error viewing balance: " + e.getMessage());
                            }
                            break;

                        case 5:
                            try {
                                bank.printAllAccounts();
                            } catch (Exception e) {
                                System.out.println("Error listing accounts: " + e.getMessage());
                            }
                            break;

                        case 6:
                            System.out.println("Goodbye!");
                            running = false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input. Please enter a number between 1 and 6.");
                    scanner.nextLine(); // Clear the scanner buffer
                } catch (Exception e) {
                    System.out.println("Error: An unexpected error occurred: " + e.getMessage());
                    scanner.nextLine(); // Clear the scanner buffer
                }
            }
        } finally {
            // Always ensure the scanner is closed
            try {
                scanner.close();
                System.out.println("Resources cleaned up successfully.");
            } catch (Exception e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}