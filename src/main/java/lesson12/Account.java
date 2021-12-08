package lesson12;

import lesson12.exception.NotEnoughMoneyException;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        if (this.balance < amount) {
            throw new NotEnoughMoneyException(this.balance, "Произошла ошибка снятия денежных средств. Текущий баланс меньше суммы снятия");
        }
        this.balance -= amount;
        return this.balance;
    }

    private void printError(String str) {
        System.out.println(str);
    }

    public double getBalance() {
        return balance;
    }
}
