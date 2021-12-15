package lesson14;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeRunner {
    public static void main(String[] args) {
        Deque<Double> doubles = new ArrayDeque<>();
        doubles.addLast(15.);
        doubles.add(-1.78);
        doubles.addFirst(10.78);
        doubles.addLast(3.14);
        doubles.add(103.19);
        doubles.addFirst(0.);
        System.out.println(doubles);
        System.out.println(doubles.removeLast());
        System.out.println(doubles);
        System.out.println(doubles.remove());
        System.out.println(doubles);
    }
}
