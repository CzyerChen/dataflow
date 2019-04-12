package com.dataflow.core.service.impl;

import com.dataflow.core.domain.TableMappingPO;
import com.dataflow.core.repository.TableMappingRepository;
import com.dataflow.core.service.TableMappingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *Yang Fan
 * 1.缺乏注释
 *
 * ziyan:findIdsByMediaMappingId
 *
 */
@Service("tableMappingServiceImpl")
public class TableMappingServiceImpl implements TableMappingService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "tableMappingRepository")
    private TableMappingRepository tableMappingRepository;

    @Override
    public TableMappingPO queryTableMappingPOById(String id) {
        TableMappingPO tableMappingPO = tableMappingRepository.findOne(id);
        logger.info(tableMappingPO.toString());
        return tableMappingPO;
    }

    @Override
    @Transactional
    public TableMappingPO addTableMappingPO(TableMappingPO tableMappingPO) {
        TableMappingPO result = tableMappingRepository.save(tableMappingPO);
        logger.info("增加或更新" + tableMappingPO);
        return result;
    }

    @Override
    @Transactional
    public void deleteTableMappingPOByid(String id) {
        tableMappingRepository.delete(id);
        logger.info("删除id：" + id);
    }

    @Override
    @Transactional
    public void deleteTableMappingPOs(List<String> ids) {
        for (String id : ids) {
            tableMappingRepository.delete(id);
            logger.info("删除id：" + id);
        }
        logger.info("删除完成");
    }

    @Override
    public List<TableMappingPO> queryAllTableMappingPOs(String condition, Integer pageNum, Integer pageSize) {
        List<TableMappingPO> list = tableMappingRepository.findAllList(condition, pageNum, pageSize);
        return list;
    }

    /**
     * 根据mediamappingid获取
     * @param mediaMappingId
     * @return
     */
    @Override
    public List<TableMappingPO> findIdsByMediaMappingId(String mediaMappingId) {
        List<TableMappingPO> tableMappingPOS = tableMappingRepository.findByMediaMappingId(mediaMappingId);

        if (tableMappingPOS != null && tableMappingPOS.size() > 0) {
            return tableMappingPOS;
        }
        return null;
    }

    /**
     * 获取表映射
     * @param ids
     * @param sourceDb
     * @param targetDb
     * @return
     */
    @Override
    public Map<String, String> findTableMappingByIds(List<String> ids,String sourceDb,String targetDb) {
        List<TableMappingPO> tableMappingPOS = tableMappingRepository.findByIdIn(ids);
        Map<String, String> tableMapping = new HashMap<>();
        if (tableMappingPOS != null && tableMappingPOS.size() > 0) {
            tableMappingPOS.forEach(t -> {
                        tableMapping.putIfAbsent(sourceDb+"."+t.getSourceTable(), targetDb+"."+t.getTargetTable());
                    }
            );
            return tableMapping;
        }
        return null;
    }
}
