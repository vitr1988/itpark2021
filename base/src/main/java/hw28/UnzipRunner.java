package hw28;

import hw28.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class UnzipRunner {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите параметры запуска программы и перезапустите ее");
            return;
        }
        System.out.println("Начал работу архиватор...");
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(ZipRunner.class, args);
        final ArchiveService archiveService = applicationContext.getBean(ArchiveService.class);
        Arrays.stream(args).findFirst().ifPresentOrElse(file -> {
            final String zip = archiveService.unzip(file, args.length >= 2 ? args[1] : null).orElseThrow(() -> new IllegalStateException("Невозможно выполнить разархивацию"));
            System.out.printf("Архиватор успешно завершил свою работу. Результат %s", zip);
        }, () -> {
            System.out.println("Необходимо указать разархивируемый файл в качестве параметра запуска программы");
            System.exit(0);
        });
    }
}
