package lesson41.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@SpringBootTest
@DisplayName("Контроллер жанров книг на реактивном подходе должен ")
public class GenreControllerTest {

    @Autowired
    private RouterFunction route;

    @Test
    @DisplayName("уметь проверять доступность эндпойнта")
    public void testApiRoute() {
        WebTestClient client = WebTestClient
                .bindToRouterFunction(route)
                .build();

        client.get()
                .uri("/api/genres")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
