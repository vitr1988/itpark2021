package hw20.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import hw20.dto.EmployeeWrapper.Fields;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = Fields.employees)
@JsonRootName(value = Fields.employees)
public class EmployeeWrapper {

    @XmlElement(name = "employee")
    @JsonProperty("employee")
    private List<Employee> employees;
}
