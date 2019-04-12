package com.dataflow.core.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Desciption ： 写入库连接信息类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WriterParamEntry {
    private String name;
    private String ip;
    private int port;
    private String username;
    private String password;
    private String connectionParam;
    private int rdbmsType;
}
