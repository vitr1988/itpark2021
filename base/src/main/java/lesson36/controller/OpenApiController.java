package lesson36.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.park.CommonDto;

@RestController
public class OpenApiController {

    @GetMapping("/test")
    @Operation(summary = "Приветсвенный сервис")
    public String hello(@Parameter(description = "Инициатор запроса", required = true) @RequestParam String initiator) {
        return String.format("Hello, %s", initiator);
    }

    @Operation(summary = "Тестовый сервис")
    @GetMapping("/common")
    public CommonDto commonDto() {
        return new CommonDto(1, "Value");
    }
}
