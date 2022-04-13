package lesson41;

import lesson41.model.Genre;
import lesson41.repostiory.GenreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@EnableMongoRepositories
@SpringBootApplication
public class WebFluxRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxRunner.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(GenreRepository genreRepository) {
        return route()
                .GET("/api/genres", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(genreRepository.findAll(), Genre.class)
                )
                .DELETE("/api/genres/{code}",
                        request -> genreRepository.deleteById(request.pathVariable("code")).flatMap(v -> ok().build())
                ).build();
    }
}
