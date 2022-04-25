package tech.itpark.mapper;

import tech.itpark.domain.Processing;
import tech.itpark.dto.ProcessingDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProcessingMapper {

    ProcessingDto toDto(Processing entity);
}
