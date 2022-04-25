package tech.itpark.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CardService", fallback = CardServiceFallback.class)
public interface CardServiceClient {

    @GetMapping("/create")
    String generateCardNumber();
}
