package lesson42.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Калькулятор должен ")
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @MockBean
    private PrintService printService;

    @Test
    @DisplayName("уметь складывать 2 числа")
    public void testSumma() {
        Assertions.assertEquals(5, calculatorService.summa(2, 3));
        Assertions.assertEquals(100, calculatorService.summa(55, 45));
    }
}
