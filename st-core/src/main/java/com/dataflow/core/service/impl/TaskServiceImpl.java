package com.dataflow.core.service.impl;

import com.dataflow.core.constant.TaskStatusEnum;
import com.dataflow.core.domain.TaskPO;
import com.dataflow.core.repository.TaskRepository;
import com.dataflow.core.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskRepository taskRepository;
    @Override
    public TaskPO saveTask(TaskPO taskPO) {
        return taskRepository.save(taskPO);
    }

    @Override
    public void deleteTaskById(String id) {
        TaskPO taskPO = taskRepository.findByIdAndDeleted(id,false);
        if(taskPO!=null){
            taskPO.setDeleted(true);
            taskRepository.save(taskPO);
        }
    }

    @Override
    public TaskPO selectTaskById(String id) {
        return taskRepository.findByIdAndDeleted(id,false);
    }


    /**
     * 获取合理的任务列表
     * @return
     */
    @Override
    public List<TaskPO> findAllValidTask() {
        List<TaskPO> list = taskRepository.findByStatusAndBeginTimeBeforeAndDeleted(TaskStatusEnum.RUNNING.getStatusNum(), new Date(), false);
        if(list != null && list.size()>0){
            return list.stream().filter(p -> StringUtils.isNotBlank(p.getReaderParams())&& StringUtils.isNotBlank(p.getWriterParams())).collect(Collectors.toList());
        }
        return null;
    }

}
