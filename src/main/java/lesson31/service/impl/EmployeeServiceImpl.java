package lesson31.service.impl;

import lesson25.entity.Department;
import lesson25.entity.Employee;
import lesson31.repository.DepartmentRepository;
import lesson31.repository.EmployeeRepository;
import lesson31.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Setter(onMethod_ = {@Lazy, @Autowired})
    private EmployeeServiceImpl self;

    @Override
    public List<Employee> findBySalary(BigDecimal salary) {
        final List<Employee> employees = employeeRepository.findBySalary(salary);
        employees.forEach(employee -> {
            final Department department = employee.getDepartment();

        });
        return employees;
    }

    @Override
    public List<Employee> findBySalaryAndName(BigDecimal salary, String name) {
        return employeeRepository.findBySalaryOrEmpName(salary, name);
    }

    @Override
    public List<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }

    @Override
    @Transactional(noRollbackFor = IllegalStateException.class, rollbackFor = URISyntaxException.class)
    public void resetSalary(Integer employeeId) {
        employeeRepository.updateById(employeeId, BigDecimal.ZERO);
        self.updateDepartment(employeeId, 14);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateDepartment(Integer employeeId, Integer departmentId) {
        employeeRepository.updateDepartmentForEmployee(
                departmentRepository.getById(departmentId),
                employeeId
        );
    }
}
