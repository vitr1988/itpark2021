package lesson18;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private BigDecimal balance;
    private Lock lock = new ReentrantLock();

    public void withdraw(BigDecimal money) {
        if (lock.tryLock()) {
            this.balance = this.balance.subtract(money);
        }
    }

    public void deposit(BigDecimal money) {
        if (lock.tryLock()) {
            this.balance = this.balance.add(money);
        } else {
            lock.unlock();
        }
    }

    public void print() {
        if (lock.tryLock()) {
            System.out.println("Баланс " + this.balance);
        }
    }
}
