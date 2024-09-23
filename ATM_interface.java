package ATM_Interface_java;
import java.util.Scanner;

	// BankAccount class to store and manage the user's account balance
class BankAccount {
	private double balance;
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	public double getBalance() {
        return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Successfully deposited: $" + amount);
			} else {
				System.out.println("Invalid deposit amount.");
	    }
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
	        System.out.println("Successfully withdrew: $" + amount);
		} else if (amount > balance) {
			System.out.println("Insufficient balance.");
		} else {
			System.out.println("Invalid withdrawal amount.");
		}
	}
}

	// ATM class to represent the machine and its functionalities
class ATM {
	private BankAccount account;
	private Scanner scanner;

	public ATM(BankAccount account) {
		this.account = account;
		this.scanner = new Scanner(System.in);
	}

	// Display menu options
	public void displayMenu() {
		System.out.println("\nATM Menu:");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
		System.out.print("Choose an option: ");
	}

	// Execute ATM transactions based on user choice
	public void execute() {
		int choice = 0;
		do {
			displayMenu();
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid choice. Please enter a number.");
				scanner.next(); // Clear invalid input
				displayMenu();
			}
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				System.out.println("Exiting ATM. Thank you for using our service!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
	        }
	    } while (choice != 4);
		}

	// Check balance method
	public void checkBalance() {
		System.out.println("Current Balance: $" + account.getBalance());
	}

	// Deposit method
	public void deposit() {
		System.out.print("Enter deposit amount: $");
		while (!scanner.hasNextDouble()) {
			System.out.println("Invalid amount. Please enter a valid number.");
			scanner.next(); // Clear invalid input
			System.out.print("Enter deposit amount: $");
		}
		double amount = scanner.nextDouble();
			account.deposit(amount);
	    }

	// Withdraw method
	public void withdraw() {
		System.out.print("Enter withdrawal amount: $");
		while (!scanner.hasNextDouble()) {
			System.out.println("Invalid amount. Please enter a valid number.");
			scanner.next(); // Clear invalid input
			System.out.print("Enter withdrawal amount: $");
		}
		double amount = scanner.nextDouble();
		account.withdraw(amount);
	    }
	}

// Main class to run the ATM program
public class ATM_interface {
	public static void main(String[] args) {
		BankAccount userAccount = new BankAccount(500.0);  // Creating a user account with an initial balance
		ATM atm = new ATM(userAccount);                   // Connecting ATM to the user's bank account
		atm.execute();                                    // Run the ATM
	}
}