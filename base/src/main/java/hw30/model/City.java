package hw30.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CITY")
public class City {
    @Id
    @Column(name = "CODE")
    private Integer code;
    @Column(name = "NAME_RUS")
    private String name;
    @Column(name = "NAME_EN")
    private String nameEn;
    @Nullable
    @Column(name = "POPULATION")
    private Long population;

    public City(Integer code, String name, String nameEn) {
        this.code = code;
        this.name = name;
        this.nameEn = nameEn;
    }
}
