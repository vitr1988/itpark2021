package tech.itpark.service;

import tech.itpark.dto.ProcessingDto;

import java.math.BigDecimal;

public interface ProcessingService {
    ProcessingDto issueCard(Long accountId);

    void spendMoney(String cardNumber, BigDecimal sum);

    ProcessingDto getProcessing(Long accountId);
}
