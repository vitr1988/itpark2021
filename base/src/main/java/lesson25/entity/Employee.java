package lesson25.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import java.math.BigDecimal;

import static lesson25.entity.Employee.DEPARTMENT_GRAPH_NAME;

@Data
@Entity
@Table(name = "employee")
@ToString(exclude = "department")
@NamedEntityGraph(name = DEPARTMENT_GRAPH_NAME, attributeNodes = {@NamedAttributeNode("department")})
public class Employee {

    public static final String DEPARTMENT_GRAPH_NAME = "Employee.department";

    @Id
    @Column(name = "emp_id")
    @GeneratedValue//(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
