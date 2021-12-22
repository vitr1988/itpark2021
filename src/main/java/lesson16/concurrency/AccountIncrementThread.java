package lesson16.concurrency;

import java.math.BigDecimal;

public class AccountIncrementThread extends Thread {

    private final Account account;
    private final BigDecimal value;

    public AccountIncrementThread(Account account, BigDecimal delta) {
        this.account = account;
        this.value = delta;
    }

    public void run() {
        account.deposit(value);
    }

}
