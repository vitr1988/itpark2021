package lesson42.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface AbstractMapper<T, D> {
    D toDocumentEntity(T entity);
    T toEntity(D entity);

    default List<D> toDocumentEntities(List<T> entities) {
        return entities.stream().map(this::toDocumentEntity).collect(Collectors.toList());
    }

    default Optional<D> toOptionalDto(Optional<T> entity) {
        return entity.map(this::toDocumentEntity);
    }
}
