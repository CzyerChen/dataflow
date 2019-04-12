package com.dataflow.core.mapper;

import com.dataflow.core.domain.TableColumnMappingPO;
import com.dataflow.core.domain.dto.TableColumnMappingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Discription 列映射mapper
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 25 17:11
 */
@Mapper(componentModel = "spring")
public interface TableColumnMappingMapper {
    TableColumnMappingDTO mappingToMappingDTO(TableColumnMappingPO mappingPO);

    void updateMappingFromDto(TableColumnMappingDTO mappingDTO, @MappingTarget TableColumnMappingPO mappingPO);
}
