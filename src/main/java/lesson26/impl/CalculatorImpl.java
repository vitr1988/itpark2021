package lesson26.impl;

import lesson26.ArgumentA;
import lesson26.ArgumentB;
import lesson26.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//("superPuperCalculator")
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

    private final ArgumentA argumentA;

//    @Autowired
    private final ArgumentB argumentB;

//    @Autowired
//    public CalculatorImpl(ArgumentA argumentA, ArgumentB argumentB) {
//        this.argumentA = argumentA;
//        this.argumentB = argumentB;
//    }
//
//    public CalculatorImpl(ArgumentA argA) {
//        this.argumentA = argA;
//        this.argumentB = new ArgumentB();
//    }

//    @Autowired
//    public void setArgumentB(ArgumentB argumentB) {
//        this.argumentB = argumentB;
//    }

    @Override
    public int summa() {
        return argumentA.getValue() + argumentB.getValue();
    }

    @Override
    public int divide() {
        return argumentA.getValue() / argumentB.getValue();
    }
}
