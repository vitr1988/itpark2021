package lesson33.controller;

import lesson33.dto.ResultDto;
import lesson33.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class InputController {

    @Value("${spring.application.name}")
    private String application;

    private final CalculatorService calculatorService;

//    @RequestMapping()
    @PostMapping("/summa")
    public ResultDto summa(@RequestParam("arg1") Integer a, @RequestParam("arg2") Integer b) {
        return new ResultDto(application, calculatorService.summa(a, b));
    }
}
