package com.dataflow.core.service;


import com.dataflow.core.domain.TableMappingPO;
import com.dataflow.core.domain.dto.TableColumnMappingDTO;

import java.util.List;
import java.util.Map;

/**
 * Ziyan: 列映射服务类
 */
public interface TableColumnMappingService {

    public TableColumnMappingDTO saveTableColumnMapping(TableColumnMappingDTO dto);

    public void deleteTabelColumnMappingById(String id);

    public TableColumnMappingDTO getTableColumnMappingById(String id);

    public List<String> findIdsByTableMappingId(String tableMappingId);

    public Map<String, String> findColumnMappingByIds(List<TableMappingPO> list);
}
