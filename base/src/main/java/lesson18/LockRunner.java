package lesson18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockRunner {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    if (lock.tryLock()) {
                        System.out.println("Стартовал поток " + Thread.currentThread().getName());
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        new Thread(() -> {
            try {
                lock.unlock();
                System.out.println("Блокировка снята потоком " + Thread.currentThread().getName());
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}
