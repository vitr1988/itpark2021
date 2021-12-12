package lesson13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LinkedListRunner {

    public static void main(String[] args) {
        List<String> words = new LinkedList<>();
        List<String[]> wordsOfWords = new LinkedList<>();
//        List<List<Set<Integer>>>
        List<Product> products = new LinkedList<>();
        words.add("Skoda");
        words.add("VW");
        words.add("ВАЗ");
        words.add("Bentley");
        words.add("Audi");
        words.add("BMW");
        words.add("Mercedez");
        words.add("Geely");

        ListIterator<String> wordListIterator = words.listIterator();
//        while (wordListIterator.hasNext()) {
//            String word = wordListIterator.next();
//        }
//        while (wordListIterator.hasPrevious()) {
//            String word = wordListIterator.previous();
//        }
        System.out.println(words);
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (new Random().nextBoolean()) {
                System.out.println("Удаляемый элемент: " + next);
                iterator.remove();
            }
        }
        System.out.println(words);
        List<String> anotherWords = List.of("Lamborghini", "Suzuki", "Ford");
        List<String> yetAnotherListOfWords = new ArrayList<>(anotherWords);
        yetAnotherListOfWords = new LinkedList<>(yetAnotherListOfWords);
        words.addAll(anotherWords);
        words.addAll(yetAnotherListOfWords);
        words.set(5, "Jeep");
        System.out.println(words);
        swap(words, 1, 3);
        System.out.println(words);
    }

    private static void swap(List<String> list, int begin, int finish) {
        if (begin >= list.size() || finish >= list.size()) {
            //TODO:
            return;
        }
        String firstElement = list.get(begin);
        String secondElement = list.get(finish);
        list.set(begin, secondElement);
        list.set(finish, firstElement);
    }

}
