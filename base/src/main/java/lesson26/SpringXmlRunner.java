package lesson26;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlRunner {

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        final BeanA bean = classPathXmlApplicationContext.getBean(BeanA.class);
        bean.print();
    }
}
