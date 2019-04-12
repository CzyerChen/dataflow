package com.dataflow.core.repository;

import com.dataflow.core.domain.TableMappingPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Yang Fan
 */
public interface TableMappingRepository extends JpaRepository<TableMappingPO, String> {
    @Query(value = "select * from hydp_table_mapping tm where (tm.source_table like %:condition% or tm.source_table is null) limit :pageNum,:pageSize", nativeQuery = true)
    List<TableMappingPO> findAllList(@Param("condition") String condition, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<TableMappingPO> findByMediaMappingId(String mediaMappingId);

    List<TableMappingPO> findByIdIn(List<String> ids);

    List<TableMappingPO> findByMediaMappingIdIn(List<String> ids);

}
