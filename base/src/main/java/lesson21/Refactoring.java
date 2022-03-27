package lesson21;

import java.math.BigDecimal;

public class Refactoring {

    private String name;
    private String color;
    private BigDecimal price;
    private int size;

    public Refactoring(String name, BigDecimal price, String color, int size) {

        print();
    }

    public Refactoring() {
    }


    public void print() {
        System.out.println("Вызвалась печать");
    }

    public String getValue() {
        return "Здесь пробный текст";
    }
}
