package lesson15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {

    private static final Integer THRESHOLD = 1000;
    static int result = 0;

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            digits.add(new Random().nextInt(THRESHOLD));
        }
        System.out.println(digits);
        System.out.println("Сумма через итерирование: " + summa(digits));
        System.out.println("Сумма через StreamApi: " + summaStream(digits));
        Stream<Integer> stream = digits.stream();

        Stream.Builder<Integer> builder = Stream.builder();
        for (int i = 0; i < 100; i++) {
            builder.add(new Random().nextInt(THRESHOLD));
        }

        Stream<String> names = Stream.of("Виталий", "Сергей", "Анна", "Петр");
        List<Integer> lengthsOfNames = names
                .peek(System.out::println)
                .limit(3)
                .skip(1)
                .map(String::length)
                .filter(i -> i % 2 == 0)
                .distinct()
                .sorted((a1, a2) -> a2 - a1)
                .collect(Collectors.toList());
        System.out.println(lengthsOfNames);

//        System.out.println(names.filter(str -> str.length() > 2).collect(Collectors.toSet()));
        System.out.println(stream.count());

//        Stream.empty()
    }

    public static long summa(Collection<Integer> ints) {
        long result = 0;
        for (Integer val : ints) {
            result += val;
        }
        return result;
    }

    public static Stream<Integer> getStream(Collection<Integer> collection) {
        return collection == null || collection.isEmpty() ? Stream.empty() : collection.stream();
    }

    public static long summaStream(Collection<Integer> ints) {
//        return ints.stream().reduce(0, Integer::sum);
//        return ints.stream().reduce((a, b) -> a + b).orElse(-1);
        result = 0;
        ints.stream().forEach(a -> result += a);
        return result;
    }
}
