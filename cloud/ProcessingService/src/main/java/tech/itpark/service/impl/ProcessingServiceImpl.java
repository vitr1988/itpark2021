package tech.itpark.service.impl;

import tech.itpark.domain.Processing;
import tech.itpark.dto.ProcessingDto;
import tech.itpark.feign.AccountServiceClient;
import tech.itpark.feign.CardServiceClient;
import tech.itpark.mapper.ProcessingMapper;
import tech.itpark.repository.ProcessingRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.service.ProcessingService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProcessingServiceImpl implements ProcessingService {

    private final ProcessingRepository processingRepository;
    private final AccountServiceClient accountServiceClient;
    private final CardServiceClient cardServiceClient;

    private final ProcessingMapper processingMapper;

    @Override
    @Transactional
    public ProcessingDto issueCard(Long accountId) {
        val accountDto = accountServiceClient.getAccount(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Has no such account with id: " + accountId));
        Processing processingEntity = new Processing(accountId);
        String cardNumber = cardServiceClient.generateCardNumber();
        processingEntity.setCard(cardNumber);
        processingRepository.save(processingEntity);
        return processingMapper.toDto(processingEntity);
    }

    @Override
    @Transactional
    public void spendMoney(String cardNumber, BigDecimal sum) {
        Processing processingEntity = processingRepository.findByCard(cardNumber);
        accountServiceClient.withdrawAccount(processingEntity.getAccountId(), sum);
    }

    @Override
    @Transactional(readOnly = true)
    public ProcessingDto getProcessing(Long accountId) {
        Processing processingEntity = processingRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Has no such processing with account id: " + accountId));
        return processingMapper.toDto(processingEntity);
    }
}
