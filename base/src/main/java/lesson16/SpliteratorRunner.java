package lesson16;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorRunner {

    public static void main(String[] args) {
        List<String> names = List.of("Виталий", "Андрей", "Петр",/**/ "Алина", "Андрей", "Дмитрий", "Наталья");
        Spliterator<String> spliterator = names.stream().spliterator();
        Spliterator<String> otherSpliterator = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println)) {
            //noop
        }
        System.out.println("-----------------");
        while (otherSpliterator.tryAdvance(System.out::println)) {
            //noop
        }
    }

}
