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
 * Desciption：数据源映射类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 12:27
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hydp_media_mapping")
public class MediaMappingPO {
    @Id
    @GeneratedValue(generator ="mediaMappingId")
    @GenericGenerator(name = "mediaMappingId",strategy = "uuid")
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

