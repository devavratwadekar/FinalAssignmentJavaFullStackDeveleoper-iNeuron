package in.ineuron.main;

import java.util.Scanner;

public class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Invalid amount. Deposit failed.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
		} else {
			System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
		}
	}

	public double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter initial balance: ");
			double initialBalance = scanner.nextDouble();

			BankAccount account = new BankAccount(initialBalance);

			while (true) {
				System.out.println("\n----- Bank Account Menu -----");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Check Balance");
				System.out.println("4. Exit");
				System.out.print("Enter your choice (1-4): ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					account.deposit(depositAmount);
					break;
				case 2:
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					account.withdraw(withdrawAmount);
					break;
				case 3:
					System.out.println("Current Balance: " + account.getBalance());
					break;
				case 4:
					System.out.println("Thank you for using the bank account program.");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		}
	}
}
