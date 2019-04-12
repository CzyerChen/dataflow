package com.dataflow.core.service.impl;

import com.dataflow.core.domain.TableColumnMappingPO;
import com.dataflow.core.domain.TableMappingPO;
import com.dataflow.core.domain.dto.TableColumnMappingDTO;
import com.dataflow.core.mapper.TableColumnMappingMapper;
import com.dataflow.core.repository.TableColumnMappingRepository;
import com.dataflow.core.service.TableColumnMappingService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Desciption  列映射服务类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 02 8:50
 */
@Service
public class TableColumnMappingServiceImpl implements TableColumnMappingService {

    @Autowired
    private TableColumnMappingRepository tableColumnMappingRepository;
    @Autowired
    private TableColumnMappingMapper tableColumnMappingMapper;


    /**
     * 保存列映射
     * @param dto
     * @return
     */
    @Override
    public TableColumnMappingDTO saveTableColumnMapping(TableColumnMappingDTO dto) {
        if(dto.getCreateTime() == null){
            dto.setCreateTime(new Date());
        }
        if(dto.getUpdateTime() == null){
            dto.setUpdateTime(new Date());
        }

        TableColumnMappingPO po = new TableColumnMappingPO();
        tableColumnMappingMapper.updateMappingFromDto(dto,po);
        TableColumnMappingPO save = tableColumnMappingRepository.save(po);
        Preconditions.checkNotNull(save);
        return tableColumnMappingMapper.mappingToMappingDTO(save);
    }

    /**
     * 删除列映射
     * @param id
     */
    @Override
    public void deleteTabelColumnMappingById(String id) {
         tableColumnMappingRepository.delete(id);
    }

    /**
     * 根据ID获取列映射
     * @param id
     * @return
     */
    @Override
    public TableColumnMappingDTO getTableColumnMappingById(String id) {
        TableColumnMappingPO mappingPO = tableColumnMappingRepository.findOne(id);
        TableColumnMappingPO tableColumnMappingPO = Preconditions.checkNotNull(mappingPO);
        return tableColumnMappingMapper.mappingToMappingDTO(tableColumnMappingPO);
    }


    /**
     * 根据tablemappingid获取
     * @param tableMappingId
     * @return
     */
    @Override
    public List<String> findIdsByTableMappingId(String tableMappingId) {
        List<TableColumnMappingPO> byTableMappingId = tableColumnMappingRepository.findByTableMappingId(tableMappingId);
        if(byTableMappingId != null && byTableMappingId.size()>0){
            return byTableMappingId.stream().map(TableColumnMappingPO::getId).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 获取列映射
     * @param list
     * @return
     */
    @Override
    public Map<String, String> findColumnMappingByIds(List<TableMappingPO> list) {
        Map<String,String> map = new HashMap<>();
        for(TableMappingPO po : list){
            List<TableColumnMappingPO> pos = tableColumnMappingRepository.findByTableMappingId(po.getId());
            String sourceTable = po.getSourceTable();
            String targetTable = po.getTargetTable();
            if(pos != null && pos.size() != 0){
                List<TableColumnMappingPO> columns = tableColumnMappingRepository.findByIdIn(pos.stream().map(TableColumnMappingPO::getId).collect(Collectors.toList()));

                for(TableColumnMappingPO columnMappingPO : columns){
                    map.put(sourceTable +"."+columnMappingPO.getSourceColumn(),targetTable+"."+columnMappingPO.getTargetColumn());
                }
            }

        }
        return map;
    }
}
