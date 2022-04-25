package tech.itpark.feign;

import tech.itpark.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class AccountServiceFallback implements AccountServiceClient {

    @Override
    public Optional<AccountDto> getAccount(Long id) {
        return Optional.empty();
    }

    @Override
    public void withdrawAccount(Long id, BigDecimal sum) {
        //noop
    }
}
