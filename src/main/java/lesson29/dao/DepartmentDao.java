package lesson29.dao;

import lesson29.model.Department;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface DepartmentDao {
    List<Department> findAll();
    Optional<Department> getById(int departmentId);
    int create(@Valid Department department);
    void update(@Valid Department department);
    void deleteById(int departmentId);
}
