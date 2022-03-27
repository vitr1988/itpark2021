package lesson8;

import java.util.Objects;

public class Cat {

    String name;
    int age;
    String poroda;
    Boss boss;

    public boolean equals(Object cat) {
        if (cat instanceof Cat c) {
            return Objects.equals(name, c.name)
                    && age == c.age
                    && Objects.equals(poroda, c.poroda)
                    && Objects.equals(boss, c.boss);
        }
        return false;
    }

    public boolean equals(Cat cat) {
        return super.equals(cat);
    }

}
