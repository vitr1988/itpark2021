package lesson31.repository;

import lesson25.entity.Department;
import lesson25.entity.Employee;
import lesson31.dto.EmployeeDto;
import lesson31.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

import static lesson25.entity.Employee.DEPARTMENT_GRAPH_NAME;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findBySalary(BigDecimal salary);

    List<Employee> findBySalaryOrEmpName(BigDecimal salary, String empName);

    @Query("select e from Employee e " +
            "where e.department.id = :depId")
    List<Employee> findEmployeeByDepartmentId(@Param("depId") Integer departmentId);

    @Query("select new lesson31.dto.EmployeeDto(e.empName, e.salary) from Employee e " +
            "where e.department.id = :departmentId")
    List<EmployeeDto> findEmployeeByDepId(Integer departmentId);


    @Query("select e.empName as name, e.salary as salary from Employee e " +
            "where e.department.id = :departmentId")
    List<EmployeeProjection> findEmployeeByDeptId(Integer departmentId);

    @Modifying
    @Query("update Employee e set e.salary = :salary " +
            "where e.id = :employeeId")
    void updateById(Integer employeeId, BigDecimal salary);

    @Modifying
    @Query("update Employee e set e.department = :department " +
            "where e.id = :employeeId")
    void updateDepartmentForEmployee(Department department, Integer employeeId);

    @Query("select e from Employee e " +
            "where e.empName = :name " +
            "order by e.id ")
    Page<Employee> findAllByEmpName(String name, Pageable page);

    @Query("select e from Employee e " +
           "join fetch e.department"
           //"join Department d on d.id = e.departmentId"
    )
    List<Employee> findAllWithDepartment();

    @EntityGraph(value = DEPARTMENT_GRAPH_NAME, type = EntityGraph.EntityGraphType.LOAD)
//    @EntityGraph(attributePaths = "department")
    List<Employee> findAllWithDepartmentsByDepartmentId(Integer departmentId);
}
