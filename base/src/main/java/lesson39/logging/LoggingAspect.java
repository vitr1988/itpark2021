package lesson39.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Order
@Component
public class LoggingAspect {

    @Before("execution(* lesson39.dao.impl.PersonDaoImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Прокси : " + joinPoint.getThis().getClass().getName());
        log.info("Класс : " + joinPoint.getTarget().getClass().getName());
        log.info("Вызов метода : " + joinPoint.getSignature().getName());
        log.info("Аргументы метода : " + Arrays.stream(joinPoint.getArgs())
                .map(Objects::toString)
                .collect(Collectors.joining(", ")));
    }
}
