package tech.itpark.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tech.itpark.dto.AccountDto;

import java.math.BigDecimal;
import java.util.Optional;

@FeignClient(name = "AccountService", fallback = AccountServiceFallback.class)
public interface AccountServiceClient {

    @GetMapping("/get/{id}")
    Optional<AccountDto> getAccount(@PathVariable Long id);

    @GetMapping("/checkout/{id}")
    void withdrawAccount(@PathVariable Long id, @RequestParam BigDecimal sum);
}
