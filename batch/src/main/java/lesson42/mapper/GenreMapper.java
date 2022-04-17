package lesson42.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface GenreMapper extends AbstractMapper<lesson42.model.sql.Genre, lesson42.model.nosql.Genre> {

}
