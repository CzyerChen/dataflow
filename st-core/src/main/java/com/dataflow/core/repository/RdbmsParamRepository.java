package com.dataflow.core.repository;


import com.dataflow.common.domain.RdbmsParamPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Yang Fan
 * 这种写法其实并不常用，SQL维护困难，DAO层数据层耦合过于紧密，不是JPA设计的初衷
 * 不用@Repository 使用包扫描，减少冗余代码，只有当相同的Repo需要执行不同操作，功能更加细化的时候采用名字区分功能，默认使用类名加载
 */
public interface RdbmsParamRepository extends JpaRepository<RdbmsParamPO, String> {
    @Query(value = "select * from hydp_rdbms_param rp where (rp.name like %:name% or rp.name is null) and deleted = 0 limit :pageNum,:pageSize", nativeQuery = true)
    List<RdbmsParamPO> findAllList(@Param("name") String name, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Modifying
    @Query(value = "UPDATE hydp_rdbms_param rp SET rp.deleted = 1 WHERE id =:id", nativeQuery = true)
    int updateRdbmsParamFieldDelete(@Param("id") String id);


    RdbmsParamPO findByIdAndDeleted(String id, boolean deleted);
}
