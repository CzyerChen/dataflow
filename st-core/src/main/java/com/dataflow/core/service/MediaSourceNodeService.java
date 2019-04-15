package com.dataflow.core.service;


import com.dataflow.common.domain.MediaSourceNodePO;

/**
 * 机器节点接口服务类
 */
public interface MediaSourceNodeService {
    public  MediaSourceNodePO  saveMediaSourceNode(MediaSourceNodePO msnp);

    public  void  deleteMediaSourceNodeById(String id);

    public  MediaSourceNodePO  selectMediaSourceNodeById(String id);
}
