package lesson42.service.impl;

import lesson42.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrintServiceImpl implements PrintService {
    @Override
    public void print(Object value) {
        log.info("Распечатываем значение {}", value);
    }
}
