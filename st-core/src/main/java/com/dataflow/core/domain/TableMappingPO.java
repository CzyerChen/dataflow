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
 * Desciption：表映射类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 12:44
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hydp_table_mapping")
public class TableMappingPO {
    @Id
    @GeneratedValue(generator ="mappingId")
    @GenericGenerator(name = "mappingId",strategy = "uuid")
    private String id;
    private String mediaMappingId;
    private String sourceTable;
    private String targetTable;
    private Date createTime;
    private Date updateTime;
}
