package lesson10;

import lesson10.enumerattion.Language;
import lesson10.inter.Printable;

public class EnumRunner {
    public static void main(String[] args) {
        Printable printable = new Printer();
        printable.printHelloWorld(Language.FRENCH);
        printable.printHelloWorld(Language.as(12));

        System.out.println(Language.GERMAN.asString());
        System.out.println(Language.GERMAN.toString());
    }
}
