package lesson31.service;

import lesson25.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    List<Employee> findBySalary(BigDecimal salary);

    List<Employee> findBySalaryAndName(BigDecimal salary, String name);

    List<Employee> findByDepartmentId(Integer id);

    void resetSalary(Integer employeeId);

    void updateDepartment(Integer employeeId, Integer departmentId);

    void updateEmployeeById(Integer employeeId, String newName);

    List<Employee> findAllByEmpName(String name);
}
