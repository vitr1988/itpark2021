package tech.itpark.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.dto.ProcessingDto;
import tech.itpark.service.ProcessingService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class ProcessingController {

    private final ProcessingService processingService;

    @GetMapping("/issue/{accountId}")
    public ProcessingDto issueCard(@PathVariable Long accountId) {
        return processingService.issueCard(accountId);
    }

    @GetMapping("/checkout/{cardNumber}")
    public void spendMoney(@PathVariable String cardNumber, @RequestParam BigDecimal sum) {
        processingService.spendMoney(cardNumber, sum);
    }

    @GetMapping("/get")
    public ProcessingDto getProcessing(@RequestParam("account_id") Long accountId) {
        return processingService.getProcessing(accountId);
    }
}
