package lesson42.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper extends AbstractMapper<lesson42.model.sql.Book, lesson42.model.nosql.Book> {

    @Mapping(target = "comments", ignore = true)
    lesson42.model.nosql.Book toDocumentEntity(lesson42.model.sql.Book book);
}
