package com.dataflow.core.service;


import com.dataflow.core.domain.TableMappingPO;

import java.util.List;
import java.util.Map;

/**
 * FanYang:表映射服务类
 */
public interface TableMappingService {

    TableMappingPO queryTableMappingPOById(String id);

    TableMappingPO addTableMappingPO(TableMappingPO tableMappingPO);

    void deleteTableMappingPOByid(String id);

    void deleteTableMappingPOs(List<String> ids);

    List<TableMappingPO> queryAllTableMappingPOs(String condition, Integer pageNum, Integer pageSize);

    List<TableMappingPO> findIdsByMediaMappingId(String mediaMappingId);

    Map<String, String>  findTableMappingByIds(List<String> ids, String sourceDb, String targetDb);

}
