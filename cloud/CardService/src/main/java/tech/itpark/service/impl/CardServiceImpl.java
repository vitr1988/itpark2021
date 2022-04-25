package tech.itpark.service.impl;

import tech.itpark.generator.CardNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.itpark.service.CardService;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardNumberGenerator cardNumberGenerator;

    @Override
    public String generateCardNumber() {
        return cardNumberGenerator.generate();
    }
}
