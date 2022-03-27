package lesson9.implementation;

import lesson9.Account;

import static lesson9.Course.CURRENT_VALUE;

public class CompanyAccount extends Account {

    public static int COUNT = 0;

//    private static final double COURSE = 75.56; // 1$ = 75.56рублей

    public CompanyAccount(String name) {
        super(name);
        COUNT++;
    }

    public double getBalanceInDollars() {
        if (isBlocked()) {
            return 0;
        }
        return this.getBalance() / CURRENT_VALUE;
    }

    @Override
    protected void printBalance() {
        System.out.println("Текущий баланс в долларах: " + getBalanceInDollars());
    }
}
