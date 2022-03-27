package lesson25.spring;

import lesson25.spring.component.Calculator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlRunner {

    public static void main(String[] args) {
        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        final Calculator calculator = (Calculator) context.getBean("calculator");
//        final Calculator calculator = context.getBean(Calculator.class);
        System.out.println(calculator.summa());
        System.out.println(calculator.multiply());

    }
}
