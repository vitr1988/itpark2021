package lesson6;

import java.util.Arrays;
import java.util.Random;

public class ArrayRunner {

    public static void main(String[] args) {
        char[] symbols = new char[10];
//        symbols[0] = '\u0000'; //0
        printArray(symbols);
        fillArray(symbols);
        System.out.println("----------------");
        printArray(symbols);
        System.out.println("----------------");
        System.out.println(indexOf(symbols, 'а'));
        System.out.println("----------------");
        System.out.println(indexOf(symbols, 'я'));
        System.out.println("----------------");
        System.out.println(String.valueOf(symbols));
        int[] intArray = new int[100]; // 0
        boolean[] booleans = new boolean[5]; // false
        String[] str = new String[3]; // null
        double[] doubleArray = new double[]{0.1, 25.1, 78};
        System.out.println(Arrays.toString(doubleArray));
        String[] strings = {"Привет", "Мир"};
        String string = strings[strings.length - 1];
        System.out.println(string);
        System.out.println(Arrays.toString(strings));
        System.out.println(weekDays().length);
    }

    public static void printArray(char[] symbols) {
//        for (int i = 0; i < symbols.length; i++) {
//            System.out.println(symbols[i]);
        for (char symbol : symbols) {
            System.out.println(symbol);
        }
    }

    public static void fillArray(char[] symbols) {
        symbols[0] = 'а';
        symbols[1] = 'б';
        symbols[2] = 'в';
        symbols[3] = 'г';
        symbols[4] = 'д';
        symbols[5] = 'е';
        symbols[6] = 'ё';
        symbols[7] = 'ж';
        symbols[8] = 'з';
        symbols[9] = 'и';
    }

    public static int indexOf(char[] symbols, char searchElement) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == searchElement) {
                return i;
            }
        }
        return -1;
    }

    public static String[] weekDays() {
        Random random = new Random();
        return random.nextBoolean() ? new String[]{"Mon", "Tue"} : new String[]{};
    }

}
