package lesson35.mapper;

import lesson35.dto.GenreDto;
import lesson35.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface GenreMapper {

    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "name", source = "entity.name")
    GenreDto toDto(Genre entity);

    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "name", source = "dto.name")
    Genre toEntity(GenreDto dto);

    default List<GenreDto> toDtos(List<Genre> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<GenreDto> toOptionalDto(Optional<Genre> entity) {
        return entity.map(this::toDto);
    }
}
