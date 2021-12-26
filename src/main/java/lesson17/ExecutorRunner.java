package lesson17;

import lesson17.callable.PrinterCallable;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorRunner {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Void> callable = () -> {
            System.out.println("Привет, мир!");
            return null;
        };
        List<Callable<Void>> threads = IntStream.range(0, 100).boxed()
                .map(i -> callable)
                .collect(Collectors.toList());
        executorService.submit(() -> System.out.println("Привет, world!"));
        executorService.invokeAll(List.of(new PrinterCallable("Hello, world!")));
        executorService.invokeAll(threads);
        Future<Integer> summa = executorService.submit(() -> {
            int i = new Random().nextInt(100);
            int j = new Random().nextInt(10);
            int result = i + j;
            System.out.println("Результат сложения " + i + " и " + j + " = " + result);
            return result;
        });
        while (!summa.isDone()) {
            Thread.sleep(10);
            System.out.println("Ждем расчета результата...");
            // ..
        }
        Integer value = summa.get();
        System.out.println("Результат работы потока " + value);
        executorService.shutdown();
    }
}
