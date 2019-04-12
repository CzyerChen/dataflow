package com.dataflow.core.repository;


import com.dataflow.common.domain.HBaseParamPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HBaseParamRepository extends JpaRepository<HBaseParamPO,String> {
}
