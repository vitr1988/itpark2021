package lesson26.impl;

import lesson26.AccountService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;

@Service
@Primary
public class AnotherAccountService implements AccountService {

    private BigDecimal balance;

    public AnotherAccountService(BigDecimal balance) {
        this.balance = balance;
        //TODO:
    }

    @Override
    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
    }

    @Override
    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }

    @Override
    public BigDecimal getCurrentBalance() {
        return null;
    }

    @PreDestroy
    public void destroy() {}

    @PostConstruct
    public void init() {}

}
