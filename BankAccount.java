class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 100) {
            balance -= amount;
        } else {
            System.out.println("Minimum balance of $100 required!");
        }
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        account.deposit(200);
        account.withdraw(100);
        System.out.println("Bank Account Balance: " + account.getBalance());

        SavingsAccount savings = new SavingsAccount(450);
        savings.withdraw(300);
        System.out.println("Savings Account Balance: " + savings.getBalance());
        savings.withdraw(250); // Should fail due to minimum balance
        System.out.println("Savings Account Balance: " + savings.getBalance());
    }
}