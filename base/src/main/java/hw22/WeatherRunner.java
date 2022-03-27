package hw22;

import com.fasterxml.jackson.databind.ObjectMapper;
import hw22.dto.WeatherDto;
import hw22.exception.MandatoryParameterSkippedException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class WeatherRunner {

    private static final ResourceBundle RESOURCES = ResourceBundle.getBundle("messages");
    private static final String EXIT_PHRASE = RESOURCES.getString("app.exit");
    private static final String APP_ID = "appId";
    private static final String API_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
    private static final ThreadLocal<ObjectMapper> OBJECT_MAPPER = new ThreadLocal<>() {
        @Override
        public ObjectMapper get() {
            return new ObjectMapper();
        }
    };

    public static void main(String[] args) throws IOException {
        final String appId = getAppId();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println(RESOURCES.getString("app.title"));
        while (inputScanner.hasNextLine()) {
            String city = inputScanner.nextLine();
            if (EXIT_PHRASE.equalsIgnoreCase(city)) {
                return;
            }
            String transformedCityName = getCityEn(city);
            Double cityTemperature = getCityTemperature(appId, transformedCityName);
            System.out.printf(RESOURCES.getString("app.result"), city, cityTemperature);
            System.out.println(RESOURCES.getString("app.nextPhrase"));
        }
    }

    private static Double getCityTemperature(String appId, String transformedCityName) throws IOException {
        URL apiUrl = new URL(String.format(API_WEATHER_URL, transformedCityName, appId));
        try (InputStream is = apiUrl.openStream()) {
            WeatherDto weatherDto = OBJECT_MAPPER.get().readValue(is, WeatherDto.class);
            return weatherDto.getMain().getTemp();
        }
    }

    private static String getAppId() {
//            return Arrays.stream(args).findFirst() // как параметр вызова программы java -jar WeatherRunner <имя_города>
//                    .orElseThrow(() -> new MandatoryParameterSkippedException("Укажите при запуске обязательный параметр appId для подключения к API"));
//            return Optional.ofNullable(System.getenv(APP_ID)) // переменные окружения
//                    .orElseThrow(() -> new MandatoryParameterSkippedException("Укажите при запуске обязательный параметр appId для подключения к API"));
        return Optional.ofNullable(System.getProperty(APP_ID))
                .orElseThrow(() -> new MandatoryParameterSkippedException(RESOURCES.getString("app.errorParameter")));
    }

    private static String getCityEn(String city) {
        try {
            return RESOURCES.getString(city);
        } catch (Exception e) {
            return "Samara";
        }
    }
}
