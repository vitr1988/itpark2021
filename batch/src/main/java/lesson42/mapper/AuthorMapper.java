package lesson42.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper extends
        AbstractMapper<lesson42.model.sql.Author, lesson42.model.nosql.Author> {
}
