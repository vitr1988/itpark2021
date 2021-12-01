package lesson10;

import lesson10.inter.Printable;

public class PrinterLauncher {

    public static void main(String[] args) {
        Printable printable = new FilePrinter();
        printable.print();
        System.out.println(Printable.INDEX);
        Printable.print("Hello World");
        printable.print(123);
    }
}
