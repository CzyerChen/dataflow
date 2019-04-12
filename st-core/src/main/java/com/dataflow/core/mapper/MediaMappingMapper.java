package com.dataflow.core.mapper;

import com.dataflow.core.domain.MediaMappingPO;
import com.dataflow.core.domain.dto.MediaMappingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Desciption  媒体映射mapper
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 8:45
 */
@Mapper(componentModel = "spring")
public interface MediaMappingMapper {
    MediaMappingDTO mediaMappingToMediaMappingDTO(MediaMappingPO mediaMappingPO);

    void updateMediaMappingFromDto(MediaMappingDTO mediaMappingDTO, @MappingTarget MediaMappingPO mediaMappingPO);

}
