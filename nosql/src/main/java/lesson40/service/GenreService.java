package lesson40.service;

import lesson40.dto.GenreDto;
import lesson40.dto.GenrePageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDto> findAll();
    GenrePageDto getPage(Pageable pageable);
    Optional<GenreDto> getByCode(@NotEmpty String genreCode);
    GenreDto save(@Valid GenreDto genre);
    void deleteByCode(@NotEmpty String genreCode);
    void delete(@Valid GenreDto genre);
}
