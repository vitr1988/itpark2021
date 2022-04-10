package lesson40.mapper;

import lesson40.dto.BookDto;
import lesson40.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {

    @Mappings({
            @Mapping(target = "id", source = "book.id"),
            @Mapping(target = "isbn", source = "book.isbn"),
            @Mapping(target = "name", source = "book.name"),
            @Mapping(target = "genreCode", source = "book.genre.code")
    })
    BookDto toDto(Book book);

    @Mappings({
            @Mapping(target = "id", source = "book.id"),
            @Mapping(target = "isbn", source = "book.isbn"),
            @Mapping(target = "name", source = "book.name")
    })
    Book toEntity(BookDto book);

    default List<BookDto> toDtos(List<Book> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<BookDto> toOptionalDto(Optional<Book> entity) {
        return entity.map(this::toDto);
    }

}
