package hw33.service;

import java.math.BigDecimal;
import java.util.Optional;

public interface ValuteService {
    Optional<BigDecimal> getValuteByCode(String code);
}
