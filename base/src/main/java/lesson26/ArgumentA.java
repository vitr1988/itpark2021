package lesson26;

import org.springframework.stereotype.Component;

@Component
public class ArgumentA implements HasValue {

    public int getValue() {
        return 125;
    }
}
