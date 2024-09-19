//  Exception for bank-related errors
class ShehabMohammedException extends Exception {
    public ShehabMohammedException(String message) {
        super(message);
    }
}

/**
 * A simple bank account class 
 */
class ShehabMohammedBank {
    // Account details
    private String name = "Shehab Mohammed";
    private String accountNumber = "202111300051";
    private double balance;

    // Constructor to initialize the account with an initial balance
    public ShehabMohammedBank(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw an amount from the account, with exception handling for insufficient or negative balance
    public void withdraw(double amount) throws ShehabMohammedException {
        if (amount > balance) {
            // Throw exception if there are insufficient funds
            throw new ShehabMohammedException("Error: Insufficient balance. Name: " + name + ", Account Number: " + accountNumber);
        } else if (balance < 0) {
            // Throow exception if the balance is negative
            throw new ShehabMohammedException("Error: Negative balance. Name: " + name + ", Account Number: " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    // Gettter method to retrieve the current balance
    public double getBalance() {
        return balance;
    }
}

/**
 * Main class to test the ShehabMohammedBank functionality.
 */
public class Main {

    public static void main(String[] args) {
        // Creating a new account with an initial balance of 500
        ShehabMohammedBank account = new ShehabMohammedBank(500);
        System.out.println("Initial balance: " + account.getBalance());

        try {
            // Test deposit and withdraw operations
            account.deposit(100);
            account.withdraw(700); // This will throw an exception
        } catch (ShehabMohammedException e) {
            // Catch and display the custom exception message
            System.out.println(e.getMessage());
        }

        try {
            // Another withdrawal operation
            account.withdraw(50);
        } catch (ShehabMohammedException e) {
            // Catch and display the custom exception message
            System.out.println(e.getMessage());
        }
    }
}