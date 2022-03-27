package lesson10;

import lesson10.inter.Checkable;
import lesson10.inter.Printable;
import lesson10.inter.PrintableAndCheckable;

public class FilePrinter extends AbstractPrinter implements PrintableAndCheckable {

    public FilePrinter() {
        super("файл");
    }

    @Override
    public void print() {
        //TODO: размещения текста в файле
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void otherPrint() {

    }
}
