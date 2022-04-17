package lesson40.repository;

import lesson40.model.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы с жанрами книг на основе Mongo JPA должен ")
@DataMongoTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository repository;

    @Test
    @DisplayName("уметь сохранять жанр и получать информацию по коду")
    public void shouldSaveAndFindByCode() {
        Genre genre = repository.save(new Genre("Art", "Искусство"));
        assertThat(genre.getCode()).isNotEmpty();
        assertThat(repository.findById("Art")).isNotNull();
    }
}
