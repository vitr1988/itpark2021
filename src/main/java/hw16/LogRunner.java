package hw16;

import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogRunner {

    private static final String FILE_NAME = "D:\\test\\test.txt";

    public static void main(String[] args) throws Exception {
        //TODO: добавить код по преждевременному удалению файла перед запуском потоков
        List<Thread> threads = IntStream.range(0, 3).boxed().map(i -> {
            final LogLevel[] logLevels = LogLevel.values();
            Logger logger = new Logger(logLevels[new Random().nextInt(logLevels.length)], FILE_NAME);
            return new Thread(logger);
        }).peek(Thread::start).collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
        try (FileReader fr = new FileReader(FILE_NAME)) {
            IOUtils.copy(fr, System.out);
        }
    }
}
