package lesson8;

import java.util.Objects;

public class Boss {
    String name;

    public Boss(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boss boss = (Boss) o;
        return Objects.equals(name, boss.name);
    }
}
