package lesson43.repository;

import lesson43.model.Genre;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы с жанрами книг на основе JPA должен ")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @DisplayName("уметь получать список всех жанров книг")
    @Test
    public void shouldReturnCorrectAllGenreList() {
        val genres = genreRepository.findAll();
        assertThat(genres).isNotNull().hasSize(11)
                .allMatch(not(s -> s.getCode().isEmpty()))
                .allMatch(not(s -> s.getName().isEmpty()));
        genres.forEach(System.out::println);
    }

    @DisplayName("уметь загружать информацию о конкретном жанре книги по его идентификатору")
    @Test
    public void shouldFindExpectedGenreById(){
        String genreCode = "com";
        val actualGenre = genreRepository.getOne(genreCode);
        assertThat(actualGenre).isNotNull()
                .hasFieldOrPropertyWithValue("code", genreCode)
                .hasFieldOrPropertyWithValue("name", "Компьютерная литература");
    }

    @DisplayName("уметь создавать жанры книги, а потом загружать информацию о нем")
    @Test
    public void shouldSaveAndLoadCorrectGenre() {
        val expectedGenre = new Genre();
        expectedGenre.setCode("hor");
        expectedGenre.setName("Ужасы");
        val actualGenre = genreRepository.save(expectedGenre);
        assertThat(actualGenre).isEqualTo(expectedGenre);
    }


    @DisplayName("уметь обновлять наименование жанра книги в БД")
    @Test
    public void shouldUpdateGenre() {
        val expectedGenre = genreRepository.getOne("pov");
        assertThat(expectedGenre).isNotNull();
        val newName = "Повесть временных лет";
        expectedGenre.setName(newName);
        genreRepository.save(expectedGenre);
        val actualGenre = genreRepository.getOne("pov");

        assertThat(actualGenre).isNotNull()
                .hasFieldOrPropertyWithValue("name", newName);
    }

    @DisplayName("уметь удалять жанр книги")
    @Test
    public void shouldDeleteGenre() {
        val genreCountBefore = genreRepository.findAll().size();
        val newGenre = new Genre();
        newGenre.setCode("neg");
        newGenre.setName("Несуществующий жанр");
        val genre = genreRepository.save(newGenre);
        genreRepository.delete(genre);
        val genreCountAfter = genreRepository.findAll().size();

        assertThat(genreCountBefore).isEqualTo(genreCountAfter);
    }
}
