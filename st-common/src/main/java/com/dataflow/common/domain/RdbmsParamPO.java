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
 * Desciption：关系数据库参数类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 10:46
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "st_rdbms_param")
public class RdbmsParamPO {
    @Id
    @GeneratedValue(generator ="rdbmsParamId")
    @GenericGenerator(name = "rdbmsParamId",strategy = "uuid")
    private String id;

    private String name;
    private String mediaSourceId;
    private String username;
    private String password;
    private String connectionParam;
    private int rdbmsType;
    private String creatorId;
    private Date createTime;
    private Date updateTime;
    private boolean deleted;
}
