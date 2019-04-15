package com.dataflow.core.service.impl;

import com.dataflow.common.domain.RdbmsParamPO;
import com.dataflow.core.repository.RdbmsParamRepository;
import com.dataflow.core.service.RdbmsParamService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("rdbmsParamServiceImpl")
public class RdbmsParamServiceImpl implements RdbmsParamService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "rdbmsParamRepository")
    private RdbmsParamRepository rdbmsParamRepository;


    /**
     * 注意软删除
     * @param id
     * @return
     */
    @Override
    public RdbmsParamPO queryRdbmsParamPOById(String id) {
        return rdbmsParamRepository.findByIdAndDeleted(id,false);
    }

    @Override
    @Transactional
    public RdbmsParamPO addRdbmsParamPO(RdbmsParamPO rdbmsParamPO) {
        RdbmsParamPO result = rdbmsParamRepository.save(rdbmsParamPO);
        logger.info("增加或更新" + rdbmsParamPO);
        return result;
    }

    @Override
    @Transactional
    public void deleteRdbmsParamPOByid(String id) {
        rdbmsParamRepository.updateRdbmsParamFieldDelete(id);
        logger.info("软删除——id：" + id );
    }

    @Override
    @Transactional
    public void deleteRdbmsParamPOs(List<String> ids) {
        for(String id:ids){
            rdbmsParamRepository.updateRdbmsParamFieldDelete(id);
            logger.info("软删除——id：" + id );
        }
        logger.info("删除完成");
    }

    @Override
    public int updateRdbmsParamPO(String condition, String id) {
        return 0;
    }

    /**
     * 注意软删除，不需要删除的数据
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<RdbmsParamPO> queryAllRdbmsParamPOs(String condition, Integer pageNum, Integer pageSize) {
        List<RdbmsParamPO> list = rdbmsParamRepository.findAllList(condition, pageNum, pageSize);
        return list;
    }
}
