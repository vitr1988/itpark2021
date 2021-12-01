package lesson10;

import lesson10.inter.PrintableAndCheckable;

public class Printer extends AbstractPrinter implements PrintableAndCheckable {

    public Printer() {
        super("консоль");
    }

    @Override
    public void print() {
        System.out.println("Печать из класса " + this.getClass().getName() + " в " + getSource());
        //TODO:4465
    }

    @Override
    public void print(int index) {
        PrintableAndCheckable.super.print(index);
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void otherPrint() {

    }
}
