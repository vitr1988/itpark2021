package lesson30.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
