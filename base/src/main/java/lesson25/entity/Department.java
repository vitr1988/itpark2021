package lesson25.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "employees")
@Entity
@Table(name = "department")
@NoArgsConstructor
public class Department {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department(Integer departmentId, String departmentName) {
        this.id = departmentId;
        this.name = departmentName;
    }
}
