package hw39;

import hw39.dto.CityDto;
import hw39.service.CityDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

@Slf4j
@SpringBootApplication
public class AspectRunner {

    private static final String KAZAN = "KAZAN";
    private static final String OREL = "OREL";

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(AspectRunner.class, args);
        final CityDictionaryService cityDictionaryService = applicationContext.getBean(CityDictionaryService.class);
        final Set<CityDto> cities = cityDictionaryService.getCities();
        log.info("Получен список городов {}", cities);

        final CityDto kazan = cityDictionaryService.getCityByCode(KAZAN).orElse(null);
        log.info("ИНформация по городу с кодом {}: {}", KAZAN, kazan);

        final CityDto orel = cityDictionaryService.getCityByCode(OREL).orElse(null);
        log.info("ИНформация по городу с кодом {}: {}", OREL, orel);
    }
}
