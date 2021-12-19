package lesson15.dto;

import java.util.Objects;

public class Account {

    private double balance;
    private String bic;
    private String holder;

    public Account() {

    }

    public Account(double balance, String bic, String holder) {
        this.balance = balance;
        this.bic = bic;
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(bic, account.bic) && Objects.equals(holder, account.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, bic, holder);
    }
}
