package lesson10.inter;

public interface PrintableAndCheckable extends Printable, Checkable {

    void otherPrint();

    default void print(int index) {
        Checkable.super.print(index);
        Printable.super.print(index);
    }
}
