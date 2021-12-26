package lesson17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountRunner {

    public static void main(String[] args) {
        Account account = new Account();
        Lock lock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            new Thread(new AccountThread(account, lock)).start();
        }
    }
}
