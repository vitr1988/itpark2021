package lesson25.spring.component.impl;

import lesson25.spring.component.Calculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorImpl implements Calculator {

    private int a;
    private int b;

    @Override
    public int summa() {
        return a + b;
    }

    @Override
    public int multiply() {
        return a * b;
    }
}
