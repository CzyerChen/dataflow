package com.dataflow.core.service;


import com.dataflow.core.domain.dto.MediaMappingDTO;

import java.util.Map;

/**
 * 数据源映射接口服务类
 */
public interface MediaMappingService {
    public MediaMappingDTO saveMediaMapping(MediaMappingDTO dto);

    public void deleteMediaMappingById(String id);

    public MediaMappingDTO getMediaMappingById(String id);

    public Map<String, Map<String,String>> findIdsByTaskId(String taskId);
}
