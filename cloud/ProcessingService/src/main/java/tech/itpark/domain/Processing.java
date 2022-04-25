package tech.itpark.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Processing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String card;
    private Long accountId;

    public Processing(Long accountId) {
        this.accountId = accountId;
    }

}
