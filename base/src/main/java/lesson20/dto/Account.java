package lesson20.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.math.BigDecimal;

@Data
@XmlRootElement
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
//    @JsonProperty("number")
//    @CsvBindByName(column = "Номер счета")
    private String accountNumber;
//    @CsvBindByName(column = "Баланс")
    private BigDecimal balance;
//    @JsonIgnore
    private Bank bank;
}
