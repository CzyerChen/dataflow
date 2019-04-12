package com.dataflow.core.service.impl;

import com.dataflow.common.domain.MediaSourceNodePO;
import com.dataflow.core.domain.MediaMappingPO;
import com.dataflow.core.domain.dto.MediaMappingDTO;
import com.dataflow.core.mapper.MediaMappingMapper;
import com.dataflow.core.repository.MediaMappingRepository;
import com.dataflow.core.service.MediaMappingService;
import com.dataflow.core.service.MediaSourceNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desciption  媒体映射服务类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 12:43
 */
@Service
public class MediaMappingServiceImpl implements MediaMappingService {
    @Autowired
    private MediaMappingRepository mediaMappingRepository;
    @Autowired
    private MediaMappingMapper mediaMappingMapper;
    @Autowired
    private MediaSourceNodeService mediaSourceNodeService;


    /**
     * 添加
     * @param dto
     * @return
     */
    @Override
    public MediaMappingDTO saveMediaMapping(MediaMappingDTO dto) {
        MediaMappingPO po = new MediaMappingPO();
        mediaMappingMapper.updateMediaMappingFromDto(dto,po);
        MediaMappingPO mappingPO = mediaMappingRepository.save(po);
        if(mappingPO != null){
            return mediaMappingMapper.mediaMappingToMediaMappingDTO(mappingPO);
        }
        return null;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteMediaMappingById(String id) {
          mediaMappingRepository.delete(id);
    }

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @Override
    public MediaMappingDTO getMediaMappingById(String id) {
        MediaMappingPO po = mediaMappingRepository.findOne(id);
        if(po != null){
            return  mediaMappingMapper.mediaMappingToMediaMappingDTO(po);
        }
        return null;
    }

    /**
     * 根据taskId获取
     * @param taskId
     * @return
     */
    @Override
    public Map<String, Map<String,String>> findIdsByTaskId(String taskId) {
        List<MediaMappingPO> byTaskId = mediaMappingRepository.findByTaskId(taskId);
        Map<String, Map<String,String>> map = new HashMap<>();
        if(byTaskId != null && byTaskId.size() >0){
           for(MediaMappingPO po : byTaskId){
               MediaSourceNodePO source = mediaSourceNodeService.selectMediaSourceNodeById(po.getSrcMediaSourceId());
               MediaSourceNodePO target = mediaSourceNodeService.selectMediaSourceNodeById(po.getTargetMediaSourceId());
               Map<String ,String > dbMap = new HashMap<>();
               dbMap.put(source.getName(),target.getName());
               map.putIfAbsent(po.getId(),dbMap);
           }
            return  map;
        }
        return null;
    }
}
