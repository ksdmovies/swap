// Base Account class
abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // Uniform interest calculation method
    public double calculateInterest() {
        return balance * getInterestRate();
    }

    // Abstract method to get the interest rate
    protected abstract double getInterestRate();

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// SavingsAccount class
class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
    }

    // Override to provide specific interest rate for SavingsAccount
    @Override
    protected double getInterestRate() {
        return 0.05;  // 5% interest rate for SavingsAccount
    }
}

// CheckingAccount class
class CheckingAccount extends Account {

    public CheckingAccount(double balance) {
        super(balance);
    }

    // Override to provide specific interest rate for CheckingAccount
    @Override
    protected double getInterestRate() {
        return 0.01;  // 1% interest rate for CheckingAccount
    }
}

// Test the solution
public class BankApp {
    public static void main(String[] args) {
        Account savingsAccount = new SavingsAccount(1000.00);
        Account checkingAccount = new CheckingAccount(1000.00);

        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Savings Account Interest: " + savingsAccount.calculateInterest());

        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
        System.out.println("Checking Account Interest: " + checkingAccount.calculateInterest());
    }
}
