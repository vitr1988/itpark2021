package lesson22;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URIRunner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URI uri = new URI("https://yandex.ru:443/news/story/Blinken_SSHA_uvereny_chto_FRG_podderzhit_obshhij_otvet_RF_priehskalacii_vokrug_Ukrainy--425024f640142523e65a58cc724fbd4f?lang=ru&rubric=personal_feed&fan=1&stid=p-G3KBXQIegwYyG-r8tc&t=1642954202&persistent_id=177912911#news");
        System.out.println("Протокол: " + uri.getScheme());
        System.out.println("Хост: " + uri.getHost());
        System.out.println("Порт: " + uri.getPort());
        System.out.println("Путь: " + uri.getPath());
        System.out.println("Параметры: " + uri.getRawQuery());
        System.out.println("Фрагмент: " + uri.getFragment());
        System.out.println("------------");
        URL url = uri.toURL();
        URLConnection urlConnection = url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
        urlConnection.connect();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
//        Scanner scanner = new Scanner(url.openStream());
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        System.out.println("-----------------");
        URL resource = URIRunner.class.getResource("/data.csv");
        System.out.println("Протокол:" + resource.toURI().getScheme());
        System.out.println("Адрес ресурса:" + resource);
    }

}
