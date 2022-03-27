package lesson26;

import lesson26.impl.CalculatorImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationRunner {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("lesson26");
        final Calculator cal = appContext.getBean(Calculator.class);
        System.out.println(cal.summa());

//        final Calculator calculator = new CalculatorImpl(new ArgumentA());
//        System.out.println(calculator.summa());
    }
}
