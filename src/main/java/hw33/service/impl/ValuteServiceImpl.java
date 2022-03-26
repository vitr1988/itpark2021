package hw33.service.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import hw33.config.ApplicationProperties;
import hw33.service.ValuteService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValuteServiceImpl implements ValuteService {

    private Map<String, BigDecimal> dictionaryValutes;

    @SneakyThrows
    public ValuteServiceImpl(ApplicationProperties applicationProperties) {
        final DocumentContext context = JsonPath.parse(applicationProperties.getCbr().getLocation());
        final List<Map<String, Object>> valutes = context.read("$.Valute.*", List.class);
        this.dictionaryValutes = valutes.stream()
                .map(it -> Pair.of(it.get("CharCode").toString(), new BigDecimal(it.get("Value").toString())))
                .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
    }

    @Override
    public Optional<BigDecimal> getValuteByCode(String code) {
        return Optional.ofNullable(this.dictionaryValutes.get(code));
    }
}
