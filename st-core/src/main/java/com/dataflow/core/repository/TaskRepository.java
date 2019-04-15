package com.dataflow.core.repository;

import com.dataflow.core.domain.TaskPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<TaskPO,String> {
     TaskPO findByIdAndDeleted(String id, boolean deleted);

     List<TaskPO> findByStatusAndBeginTimeBeforeAndDeleted(int status, Date beginTime, boolean deleted);
}
