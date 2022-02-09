package lesson27;

import lesson24.dto.Employee;
import lesson27.config.AppConfig;
import lesson27.dao.DepartmentRepository;
import lesson27.dao.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class SpringRunner {
    public static void main(String[] args) throws SQLException {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        employeeRepository.save(new Employee());

        final DepartmentRepository de = applicationContext.getBean(DepartmentRepository.class);
        try (final Connection connection = de.getConnection()) {
            //TODO:
        }

    }
}
