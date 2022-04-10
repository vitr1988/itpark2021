package lesson40.service;

import lesson40.dto.BookDto;
import lesson40.dto.BookPageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> findAll();
    BookPageDto getPage(Pageable pageable);
    Optional<BookDto> getById(String bookId);
    BookDto save(@Valid BookDto book);
    void partialSave(@Valid BookDto book);
    void deleteById(String bookId);
    void delete(@Valid BookDto book);
}
