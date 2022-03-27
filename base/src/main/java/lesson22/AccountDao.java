package lesson22;

import lesson22.dto.Account;

import java.math.BigDecimal;
import java.util.List;

public class AccountDao {

    public List<Account> getAccounts() {
        //TODO: физическое извлечение данных из БД
        return List.of(Account.builder().name("account1").balance(BigDecimal.ZERO).build(),
                Account.builder().name("account1").balance(BigDecimal.valueOf(1000)).build(),
                Account.builder().name("account1").balance(new BigDecimal("5000")).build());
    }
}
