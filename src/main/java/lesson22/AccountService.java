package lesson22;

import lesson22.dto.Account;

import java.math.BigDecimal;
import java.util.Comparator;

public class AccountService {

    public BigDecimal getMaxBalance(AccountDao accountDao) {
        return accountDao.getAccounts().stream()
                .max(Comparator.comparing(Account::getBalance))
                .map(Account::getBalance)
                .orElse(BigDecimal.ZERO);
    }
}
