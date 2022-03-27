package lesson12.exception;

public class NotEnoughMoneyException extends RuntimeException {

    private double balance;

    public NotEnoughMoneyException(double balance) {
        this.balance = balance;
    }

    public NotEnoughMoneyException(double balance, String message) {
        super(message);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
