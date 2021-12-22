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
        account.withdraw(value);
    }
}
