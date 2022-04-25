package tech.itpark.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.domain.Account;
import tech.itpark.service.AccountService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/create")
    public Long createAccount(@RequestParam("client_id") Long clientId) {
        return accountService.createAccount(clientId);
    }

    @GetMapping("/fund/{id}")
    public void depositAccount(@PathVariable Long id, @RequestParam BigDecimal sum) {
        accountService.depositAccount(id, sum);
    }

    @GetMapping("/checkout/{id}")
    public void withdrawAccount(@PathVariable Long id, @RequestParam BigDecimal sum) {
        accountService.withdrawAccount(id, sum);
    }

    @GetMapping("/get/{id}")
    public Optional<Account> getAccount(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @Async
    @Bulkhead(name = "account", type = Bulkhead.Type.THREADPOOL)
    @TimeLimiter(name = "account")
    @CircuitBreaker(name = "account", fallbackMethod = "fallbackMethod")
    @GetMapping("/fallback/{id}")
    public CompletableFuture<Long> fallback(@PathVariable Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Has no accounts with negative ids");
        }
        return CompletableFuture.completedFuture(id);
    }

    private CompletableFuture<Long> fallbackMethod(Long id, IllegalArgumentException e) {
        return CompletableFuture.completedFuture(-1L);
    }
}
