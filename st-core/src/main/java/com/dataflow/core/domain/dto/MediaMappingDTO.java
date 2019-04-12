package com.dataflow.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Desciption  媒体映射类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 8:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaMappingDTO {
    private String id;
    private String taskId;

    private String srcMediaSourceId;
    private  int srcMediaSourceType;

    private String targetMediaSourceId;
    private  int targetMediaSourceType;

    private String parameter;
    private  int columnMappingMode;

    private Date createTime;
    private Date updateTime;
}
