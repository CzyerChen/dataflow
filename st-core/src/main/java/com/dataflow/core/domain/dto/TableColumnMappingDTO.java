package com.dataflow.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Discription  列映射类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 25 17:11
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableColumnMappingDTO {
    private String id;
    @NotNull
    private String tableMappingId;
    @NotNull
    private String sourceColumn;
    @NotNull
    private String targetColumn;

    private Date createTime;
    private Date updateTime;
}
