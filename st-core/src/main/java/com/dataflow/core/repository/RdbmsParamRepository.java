package com.dataflow.core.repository;


import com.dataflow.common.domain.RdbmsParamPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RdbmsParamRepository extends JpaRepository<RdbmsParamPO, String> {
    @Query(value = "select * from hydp_rdbms_param rp where (rp.name like %:name% or rp.name is null) and deleted = 0 limit :pageNum,:pageSize", nativeQuery = true)
    List<RdbmsParamPO> findAllList(@Param("name") String name, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Modifying
    @Query(value = "UPDATE hydp_rdbms_param rp SET rp.deleted = 1 WHERE id =:id", nativeQuery = true)
    int updateRdbmsParamFieldDelete(@Param("id") String id);


    RdbmsParamPO findByIdAndDeleted(String id, boolean deleted);
}
