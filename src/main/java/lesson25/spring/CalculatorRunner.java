package lesson25.spring;

import lesson25.spring.component.Calculator;
import lesson25.spring.component.ParametrizedCalculator;
import lesson25.spring.component.impl.CalculatorImpl;
import lesson25.spring.component.impl.ParametrizedCalculatorImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorRunner {
    public static void main(String[] args) {
//        Calculator calculator = new CalculatorImpl(45, 5);
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        Calculator calculator = classPathXmlApplicationContext.getBean(Calculator.class);

        System.out.println("Умножение двух чисел " + calculator.multiply());
        System.out.println("Сложение двух чисел " + calculator.summa());

//        ParametrizedCalculator parametrizedCalculator = classPathXmlApplicationContext.getBean(ParametrizedCalculator.class);
//        System.out.println("Умножение двух чисел " + parametrizedCalculator.multiply(40, 45));
//        System.out.println("Сложение двух чисел " + parametrizedCalculator.summa(12, 80));

        ParametrizedCalculatorImpl parametrizedCalculator = classPathXmlApplicationContext.getBean(ParametrizedCalculatorImpl.class);
        System.out.println("Умножение двух чисел " + parametrizedCalculator.multiply(40, 45));
        System.out.println("Сложение двух чисел " + parametrizedCalculator.summa(12, 80));

    }
}
