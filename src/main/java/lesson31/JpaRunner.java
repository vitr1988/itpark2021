package lesson31;

import lesson31.repository.EmployeeRepository;
import lesson31.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@Slf4j
@EntityScan({"lesson31", "lesson25.entity"})
@SpringBootApplication
public class JpaRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(JpaRunner.class, args);
        final EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        final EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        final BigDecimal salary = new BigDecimal("78000");
        log.info("Сотрудники с зарплатой {} {}", salary, employeeService.findBySalary(salary));

        final String lastName = "Ivanov";
        log.info("Сотрудники с зарплатой {} и фамилией {} {}", salary, lastName, employeeService.findBySalaryAndName(salary, lastName));

        final Integer departmentId = 1;
        log.info("Сотрудники с департамент, идентификатор которого равен {}, {}", departmentId, employeeService.findByDepartmentId(departmentId));

        log.info("Сотрудники с департамента, идентификатор которого равен {}, {}", departmentId, employeeRepository.findEmployeeByDepId(departmentId));

        employeeRepository.findEmployeeByDeptId(departmentId).forEach(employeeProjection -> {
            log.info("Сотрудник с департамента, идентификатор которого равен {}, {}", departmentId, employeeProjection.asString());
        });

        employeeService.resetSalary(19);

//        employeeService.updateEmployeeById(15, "Эрнст Неизвестный");

        log.info("All Ivanovs: {}", employeeService.findAllByEmpName("Ivanov"));

        log.info("All employees with department {}", employeeRepository.findAllWithDepartmentsByDepartmentId(1));
    }
}
