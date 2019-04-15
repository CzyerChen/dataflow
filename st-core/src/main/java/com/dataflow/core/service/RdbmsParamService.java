package com.dataflow.core.service;

import com.dataflow.common.domain.RdbmsParamPO;

import java.util.List;

/**
 * 关系数据库参数接口服务类
 */
public interface RdbmsParamService {

    RdbmsParamPO queryRdbmsParamPOById(String id);

    RdbmsParamPO addRdbmsParamPO(RdbmsParamPO rdbmsParamPO);

    void deleteRdbmsParamPOByid(String id);

    void deleteRdbmsParamPOs(List<String> ids);

    int updateRdbmsParamPO(String condition, String id);

    List<RdbmsParamPO> queryAllRdbmsParamPOs(String condition, Integer pageNum, Integer pageSize);
}
