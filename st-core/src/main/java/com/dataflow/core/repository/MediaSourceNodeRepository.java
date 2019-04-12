package com.dataflow.core.repository;


import com.dataflow.common.domain.MediaSourceNodePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Qi Hua
 */
public interface MediaSourceNodeRepository extends JpaRepository<MediaSourceNodePO,String> {

    MediaSourceNodePO findByIdAndDeleted(String id, boolean deleted);
}
