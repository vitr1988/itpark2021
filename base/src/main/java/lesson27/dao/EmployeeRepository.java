package lesson27.dao;

import lesson24.dto.Employee;

public interface EmployeeRepository {
    void save(Employee dto);
}
