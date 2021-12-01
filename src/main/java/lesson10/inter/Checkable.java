package lesson10.inter;

public interface Checkable {
    boolean check();

    default void print(int index) {
        System.out.println("Совершенно другой текст");
    }
}
