package tech.itpark.repository;

import tech.itpark.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Lock balanceLock = new ReentrantLock();

    List<Account> findByClientId(Long clientId);

    default boolean addBalance(Long id, BigDecimal balance) {
        balanceLock.lock();
        try {
            return findById(id).map(account -> {
                account.setBalance(account.getBalance().add(balance));
                if (account.getBalance().compareTo(BigDecimal.ZERO) >= 0) {
                    return save(account);
                }
                return null;
            }).isPresent();
        } finally {
            balanceLock.unlock();
        }
    }
}
