package lesson26;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AggregateService {

    private final List<AccountService> accountServices;
    private final Map<String, AccountService> accountServiceMap;

    public void withdrawAll(BigDecimal money) {
        accountServices.forEach(it -> it.withdraw(money));
    }
}
