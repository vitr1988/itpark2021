package lesson29.dao;

import lesson29.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
