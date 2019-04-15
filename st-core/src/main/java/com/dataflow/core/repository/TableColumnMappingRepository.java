package com.dataflow.core.repository;

import com.dataflow.core.domain.TableColumnMappingPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableColumnMappingRepository extends JpaRepository<TableColumnMappingPO,String> {
    List<TableColumnMappingPO> findByTableMappingId(String tableMappingId);

    List<TableColumnMappingPO> findByIdIn(List<String> ids);
}
