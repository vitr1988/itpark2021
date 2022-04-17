package lesson41.repository;

import lesson41.model.Genre;
import lesson41.repostiory.GenreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@DisplayName("Репозиторий для работы с жанрами книг на реактивном подходе должен ")
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository repository;

    @Test
    @DisplayName("уметь сохранять жанры книг")
    public void shouldSaveNewGenre() {
        Mono<Genre> genreMono = repository.save(new Genre("Art", "Искусство"));

        StepVerifier
                .create(genreMono)
                .assertNext(genre -> assertThat(genre.getCode()).isNotEmpty())
                .expectComplete()
                .verify();
    }

    @Test
    @DisplayName("уметь сохранять жанр и получать информацию по коду")
    public void shouldSaveAndFindByCode() {
        repository.save(new Genre("Art", "Искусство"))
                .subscribe(System.out::println);

        StepVerifier.create(repository.findById("Art"))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}
