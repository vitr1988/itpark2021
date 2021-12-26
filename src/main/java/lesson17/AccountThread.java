package lesson17;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class AccountThread implements Runnable {

    private Account account;
    private Lock lock;

    public AccountThread(Account account, Lock lock) {
        this.account = account;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (!lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(100);
            }
            int value = new Random().nextInt(500);
            System.out.println("Пополнение осуществляется на " + value);
            account.fill(value);
            System.out.println("Текущий баланс : " + account.getBalance());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

    }
}
