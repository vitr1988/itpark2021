package lesson33.service.impl;

import lesson33.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    //repository

    @Override
    public int summa(int a, int b) {
        return a + b;
    }
}
