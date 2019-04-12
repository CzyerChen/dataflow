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
 * Desciption：hbase 数据源参数类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 11:05
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "st_hbase_param")
public class HBaseParamPO {
    @Id
    @GeneratedValue(generator ="hbaseParamId")
    @GenericGenerator(name = "hbaseParamId",strategy = "uuid")
    private String id ;
    private String name;
    private String mediaSourceId;
    private String znode;
    private int zport;
    private String creatorId;
    private Date createTime;
    private Date updateTime;
    private  boolean deleted;

}
