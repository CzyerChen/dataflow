package com.dataflow.core.repository;

import com.dataflow.core.domain.TableColumnMappingPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Desciption 列映射
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 02 8:48
 */
public interface TableColumnMappingRepository extends JpaRepository<TableColumnMappingPO,String> {
    List<TableColumnMappingPO> findByTableMappingId(String tableMappingId);

    List<TableColumnMappingPO> findByIdIn(List<String> ids);
}
