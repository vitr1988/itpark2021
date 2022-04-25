package tech.itpark.service;

import tech.itpark.domain.Account;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountService {

    Long createAccount(Long clientId);

    void depositAccount(Long accountId, BigDecimal money);

    void withdrawAccount(Long id, BigDecimal sum);

    Optional<Account> findById(Long id);
}
