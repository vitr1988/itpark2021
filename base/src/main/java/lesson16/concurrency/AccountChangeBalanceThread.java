package lesson16.concurrency;

import java.math.BigDecimal;

public class AccountChangeBalanceThread extends Thread {

    private final Account account;

    public AccountChangeBalanceThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            synchronized (account) {
                System.out.println("Осуществляем изменение баланса на счете из " + Thread.currentThread().getName());
                account.deposit(new BigDecimal(2000));
                Thread.sleep(1000);
                account.deposit(new BigDecimal(2000));
            }
            System.out.println("Текущее состояние счета: " + account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
