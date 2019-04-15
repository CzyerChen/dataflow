package com.dataflow.core.service;

import com.dataflow.core.domain.TaskPO;

import java.util.List;

/**
 *任务接口服务类
 */
public interface TaskService {
    public TaskPO saveTask(TaskPO taskPO);

    public void deleteTaskById(String id);

    public TaskPO selectTaskById(String id);

    public List<TaskPO> findAllValidTask();

}
