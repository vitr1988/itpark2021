package lesson15;

@FunctionalInterface
public interface Moveable {

    void move();

//    void moveDistance(int distance);

    default void moveAndPrint() {
        print("Начало движения");
        move();
        print("Конец движения");
    }

    static void print(String str) {
        System.out.println(str);
    }
}
