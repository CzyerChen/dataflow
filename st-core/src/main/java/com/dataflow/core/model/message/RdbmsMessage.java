package com.dataflow.core.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Desciption ： Kafka数据传输实体
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 9:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RdbmsMessage extends AbstractMessage implements Serializable {
    private String taskId;
    private String sourceType;//mysql postgesql
    private PositionInfo positionInfo;
    private String operationType;//DDL DCL DML
    private RdbmsOperation rdbmsOperation;
}
