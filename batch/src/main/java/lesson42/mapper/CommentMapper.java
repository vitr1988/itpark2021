package lesson42.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CommentMapper extends AbstractMapper<lesson42.model.sql.Comment, lesson42.model.nosql.Comment> {

    @Mapping(target = "book", ignore = true)
    lesson42.model.nosql.Comment toDocumentEntity(lesson42.model.sql.Comment comment);
}
