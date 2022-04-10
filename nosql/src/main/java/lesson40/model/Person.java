package lesson40.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private int id;
    private String name;
}
