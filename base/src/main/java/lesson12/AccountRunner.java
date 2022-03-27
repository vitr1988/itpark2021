package lesson12;

import lesson12.exception.NotEnoughMoneyException;

public class AccountRunner {
    public static void main(String[] args) {
        Account account = new Account(1_000);
        System.out.println("Текущий баланс " + account.getBalance());
        try {
            int amount = 5_000;
            account.withdraw(amount);
        } catch (NotEnoughMoneyException exception) {
            exception.printStackTrace();
            System.out.println("Снятия не произошло! Состояние баланса " + exception.getBalance());
        }
        System.out.println("Текущий баланс " + account.getBalance());
    }
}
