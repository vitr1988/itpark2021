package lesson20.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

import java.math.BigDecimal;

@Data
//@XmlRootElement(name = "auto")
@XmlType(propOrder = {"model", "price", "mark", "owner"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute(name = "m")
    private String mark;

    @XmlAttribute(name = "ml")
    private String model;

    @XmlAttribute
    private BigDecimal price;

//    @XmlTransient
    @XmlElement(name = "driver")
    private /*transient*/ Owner owner;

//    @XmlElement(name = "m")
//    public String getMark() {
//        return mark;
//    }
}
