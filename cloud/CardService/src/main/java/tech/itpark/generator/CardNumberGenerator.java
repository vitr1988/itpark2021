package tech.itpark.generator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CardNumberGenerator {
    private Random random = new Random(System.currentTimeMillis());

    public String generate() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            Integer digit = this.random.nextInt(10);
            builder.append(digit);
        }
        Integer checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);
        return builder.toString();
    }

    private Integer getCheckDigit(String number) {
        Integer sum = 0;
        for (int i = 0; i < number.length(); i++) {
            Integer digit = Integer.parseInt(number.substring(i, (i + 1)));
            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        Integer mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }
}