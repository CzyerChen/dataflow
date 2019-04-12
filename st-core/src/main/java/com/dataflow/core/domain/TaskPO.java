package com.dataflow.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Desciption：任务实体类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 11:36
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hydp_base_task")
public class TaskPO {
    @Id
    @GeneratedValue(generator ="taskId")
    @GenericGenerator(name = "taskId",strategy = "uuid")
    private String id;
    private String taskName;
    private String taskResume;
    private int taskType;
    private String groupId;
    private String creatorId;
    private Date createTime;
    private Date updateTime;
    private Date beginTime;
    private Date endTime;
    private boolean deleted;
    private String readerParams;
    private String writerParams;
    private int status;
    private int syncMode;
}
