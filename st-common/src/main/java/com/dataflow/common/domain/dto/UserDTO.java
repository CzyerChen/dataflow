package com.dataflow.common.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Discription  用户DTO类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 25 13:43
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    @NotNull
    private String name;
    private  String email;
    @NotNull
    private String phone;
    @Min(1)
    private int roleCode;
    private Date createTime;
    private Date updateTime;
    private  boolean deleted;
}

