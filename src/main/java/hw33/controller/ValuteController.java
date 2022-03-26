package hw33.controller;

import hw26.service.ValuteFetcher;
import hw33.dto.ValuteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ValuteController {

    private final ValuteFetcher valuteFetcher;

    @GetMapping("/currency")
    public ValuteDto getValue(@RequestParam String code) {
        return new ValuteDto(code, valuteFetcher.getValuteByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Информации по валюте с кодом %s не найдено в системе", code))));
    }
}
