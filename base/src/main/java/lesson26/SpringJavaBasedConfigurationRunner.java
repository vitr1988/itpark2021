package lesson26;

import lesson26.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class SpringJavaBasedConfigurationRunner {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final AccountService accountService = annotationConfigApplicationContext.getBean(AccountService.class);
//        final AccountService accountService = (AccountService) annotationConfigApplicationContext.getBean("accountService");
        accountService.deposit(new BigDecimal("1000"));
        accountService.withdraw(new BigDecimal("500"));
        accountService.deposit(new BigDecimal("300"));
        System.out.println(accountService.getCurrentBalance());

        final AggregateService bean = annotationConfigApplicationContext.getBean(AggregateService.class);
        bean.withdrawAll(new BigDecimal(100));
    }
}
