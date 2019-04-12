package com.dataflow.core.model.jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desciption 连接信息类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 13:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectionInfo {
    private String className;
    private String jdbcUrl;
    private String username;
    private String password;
}
