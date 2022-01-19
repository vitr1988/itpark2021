package lesson21.Calc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calc {

    private int arg1;
    private int arg2;

    public int summa() {
        return arg1 + arg2;
    }

    public int division() {
        return arg1 / arg2;
    }
}
