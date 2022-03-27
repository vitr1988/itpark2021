package lesson19;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIORunner {
    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("D:\\test", ".", "test.txt");
        System.out.println("Путь до файла: " + filePath);
        System.out.println("Имя файла: " + filePath.getFileName().toFile());
        System.out.println("Путь до файла: " + filePath.normalize());
//        Files.copy(filePath, System.out);
        Files.write(filePath.normalize(), new String("Новая строка").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        System.out.println(Files.lines(filePath).collect(Collectors.joining(",")));
        try(BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {

        }
    }
}
