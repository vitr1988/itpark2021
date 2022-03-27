package lesson31.projection;

import java.math.BigDecimal;

public interface EmployeeProjection {

    String getName();
    BigDecimal getSalary();

    default String asString() {
        return String.format("EmployeeProjection[name=%s, salary=%f]", getName(), getSalary());
    }
}
