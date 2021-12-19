package lesson15;

import java.util.ArrayList;
import java.util.List;

public class AnonymousRunner {

    public static void main(String[] args) {
        final String value = "Тестовая строка";
        Comparable<String> comparator = (String name) -> {
            System.out.println("На вход получили значение " + name);
            return value.compareTo(name);
        };
        int anotherStringAsResult = comparator.compareTo("Другая тестовая строка");
        System.out.println(anotherStringAsResult);
//        Moveable moveable = new Moveable() { // old-school in anonymous classes
//            @Override
//            public void move() {
//
//            }
//        };

        Moveable moveable = () -> {
            System.out.println("Мы находимся в движении");
            //TODO: реализовать логику
        };

        Copyable<String> methodForCopy = (origin, copyCount) -> {
            String result = "";
            for (int i = 0; i < copyCount; i++) {
                result += origin;
            }
            return result;
        };

        List<String> words = new ArrayList<>();
        words.add("Новая строка");
        words.add("Старая строка");
        words.add("Еще одна строка");
        words.add("Последняя строка");
        words.sort((str1, str2) -> str2.length() - str1.length());
        System.out.println(words);
    }
}
