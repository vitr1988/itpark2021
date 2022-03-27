package lesson20.dto;

import com.opencsv.bean.CsvBindByName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "bic", "name"})
public class Bank {

    @XmlAttribute(name = "id")
    @CsvBindByName(column = "Идентификатор Банка")
    private Long id;
    @CsvBindByName(column = "Наименование Банка")
    private String name;
    @XmlAttribute(name = "bic")
    @CsvBindByName(column = "БИК")
    private String bic;
}
