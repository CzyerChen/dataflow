package com.dataflow.core.repository;


import com.dataflow.core.domain.MediaMappingPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ClaireChen
 */
public interface MediaMappingRepository extends JpaRepository<MediaMappingPO,String> {

    List<MediaMappingPO> findByTaskId(String taskId);
}
