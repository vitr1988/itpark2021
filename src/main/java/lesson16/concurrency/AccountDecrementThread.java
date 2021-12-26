package lesson16.concurrency;

import java.math.BigDecimal;

public class AccountDecrementThread extends Thread {

    private final Account account;
    private final BigDecimal value;

    public AccountDecrementThread(Account account, BigDecimal delta) {
        this.account = account;
        this.value = delta;
    }

    public void run() {
        synchronized (account) {
            System.out.println("Осуществляем снятие ДС со счета из " + Thread.currentThread().getName());
            account.withdraw(value);
            System.out.println("Текущее состояние счета: " + account.getBalance());
        }
    }
}
