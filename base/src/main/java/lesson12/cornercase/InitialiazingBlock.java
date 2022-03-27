package lesson12.cornercase;

import lesson12.exception.UnnamedException;

import java.util.Random;

public class InitialiazingBlock {

    private final String name;

    static {
        if (true/*new Random().nextBoolean()*/) {
            throw new UnnamedException("Неизвестный блок");
        }
    }

    public InitialiazingBlock()/* throws UnnamedException*/ {
//        throw new UnnamedException("Задайте имя объекту");
        this.name = "Unknown";
    }

    public InitialiazingBlock(String name)/* throws UnnamedException*/ {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
