class ShehabMohammedException extends Exception {
    public ShehabMohammedException(String message) {
        super(message);
    }
}

class ShehabMohammedBank {
    private String accountNumber = "202111300051";
    private String name = "Shehab Mohammed";
    private double balance;

    public ShehabMohammedBank(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) throws ShehabMohammedException {
        if (amount > balance) {
            throw new ShehabMohammedException("Error: Insufficient balance. Name: " + name + ", Account Number: " + accountNumber);
        } else if (balance < 0) {
            throw new ShehabMohammedException("Error: Negative balance. Name: " + name + ", Account Number: " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        ShehabMohammedBank account = new ShehabMohammedBank(500);

        try {
            account.deposit(100);   // Deposit 100
            account.withdraw(700);  // Attempt to withdraw 700
        } catch (ShehabMohammedException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(50);  // Attempt to withdraw 50
        } catch (ShehabMohammedException e) {
            System.out.println(e.getMessage());
        }
    }
}