// Real Subject
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + ". Current balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". Current balance: $" + balance);
            return true;
        } 
        return false;
    }
}


class BankAccountProxy {
    private BankAccount realAccount;

    public BankAccountProxy(double initialBalance) {
        this.realAccount = new BankAccount(initialBalance);
    }

    public void deposit(double amount) {
        realAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        if (realAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal denied.");
        }
    }
}


public class ProxyPatternDemo {
    public static void main(String[] args) {
        BankAccountProxy account = new BankAccountProxy(500);

        account.deposit(200);
        account.withdraw(100);
        account.withdraw(700);
    }
}
