package lesson9;

public abstract class Account {

    private final String owner;
    private double balance = 0.0;
    private boolean blocked;

    public Account(String name) {
        this.owner = name;
        this.balance = 0.0;
        this.blocked = true;
    }

    public Account() {
        this("Unknown");
    }

    public boolean deposit(double amount) {
        if (isBlocked()) {
            return false;
        }
        balance += amount;
        return true;
    }

    protected boolean isBlocked() {
        return this.blocked;
    }

    public boolean withdraw(double amount) {
        if (blocked) {
            return false;
        }
        if (this.balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    void activated() {
        this.blocked = false;
    }

    public final double getBalance() {
        return balance;
    }

    protected abstract void printBalance();
}
