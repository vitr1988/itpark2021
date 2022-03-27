package hw18;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class FileParserRunner {

    private static final String FILE_LOCATION = "/example.txt";

    public static void main(String[] args) {
        System.out.println("Начало чтения и обработки файла");
        InputStream resourceAsStream = FileParserRunner.class.getResourceAsStream(FILE_LOCATION);
        if (resourceAsStream == null) {
            return;
        }
        val extension = FilenameUtils.getExtension(FILE_LOCATION);
        val index = new AtomicInteger();
        readAndParse(resourceAsStream, line -> writeToFile(extension, index, line));
    }

    @SneakyThrows(IOException.class)
    public static void readAndParse(InputStream is, Consumer<String> consumer) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))) {
            bufferedReader.lines().filter(StringUtils::isNotBlank).forEach(consumer);
        }
    }

    @SneakyThrows
    private static void writeToFile(String extension, AtomicInteger index, String line) {
        Path path = Paths.get("D:\\out", "result" + index.incrementAndGet() + "." + extension);
        System.out.printf("Начало записи файла %s\n", path.getFileName());
        Path fileParentPath = path.getParent();
        if (!Files.exists(fileParentPath)) {
            if (!fileParentPath.toFile().mkdirs()) {
                System.out.println("Во время создания директорий произошла ошибка");
                return;
            }
        }
        Files.writeString(path, line, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }
}
