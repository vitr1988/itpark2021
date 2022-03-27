package lesson29.dao.impl;

import lesson29.dao.DepartmentDao;
import lesson29.dao.EmployeeDao;
import lesson29.model.Department;
import lesson29.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@Repository
public class EmployeeDaoJdbc implements EmployeeDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Employee> employeeRowMapper;

    public EmployeeDaoJdbc(NamedParameterJdbcOperations jdbcOperations, DepartmentDao departmentDao) {
        this.jdbcOperations = jdbcOperations;
        this.employeeRowMapper = (rs, row) -> {
            final Employee employee = new Employee();
            employee.setId(rs.getInt("emp_id"));
            employee.setEmpName(rs.getString("emp_name"));
            Department department = departmentDao.getById(rs.getInt("department_id")).orElse(null);
            employee.setDepartment(department);
            employee.setSalary(rs.getBigDecimal("salary"));
            return employee;
        };
    }

    @Override
    public List<Employee> findAll() {
        //language=SQL
        final String sql = "SELECT * FROM employee e";
        return jdbcOperations.query(sql, employeeRowMapper);
    }
}
