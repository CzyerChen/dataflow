package com.dataflow.common.domain;

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
 * Desciption：机器节点类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 10:14
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "st_media_source_node")
public class MediaSourceNodePO {
    @Id
    @GeneratedValue(generator ="madiaSourceNodeId")
    @GenericGenerator(name = "madiaSourceNodeId",strategy = "uuid")
    private  String id;

    private String name;
    private String ip;
    private int port;
    private int status;
    private String resume;
    private int mediaType;
    private String  creatorId;
    private Date createTime;
    private Date updateTime;
    private boolean deleted;
}
