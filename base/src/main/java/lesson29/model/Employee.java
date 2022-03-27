package lesson29.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {

    private Integer id;
    private String empName;
    private BigDecimal salary;
    private Department department;
}
