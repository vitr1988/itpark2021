package lesson22;

import java.util.Arrays;

public class AverageService {

    public int avg(int a, int b) {
        return (a + b) / 2;
    }

    public int avg(int... values) {
        return Arrays.stream(values).reduce(0, (a, b) -> a + b) / values.length;
    }
}
