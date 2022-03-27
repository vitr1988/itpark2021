package lesson26;

import org.springframework.stereotype.Component;

@Component
public class ArgumentB implements HasValue{

    public int getValue() {
        return 25;
    }
}
