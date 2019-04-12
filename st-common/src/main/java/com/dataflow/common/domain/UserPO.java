package com.dataflow.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Desciption 用户类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 11:32
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "st_user")
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  String email;
    private String phone;
    private int roleCode;
    private Date createTime;
    private Date updateTime;
    private  boolean deleted;


}
