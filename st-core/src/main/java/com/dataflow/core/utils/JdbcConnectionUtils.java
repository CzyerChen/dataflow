package com.dataflow.core.utils;

import com.dataflow.common.model.BussinessException;
import com.dataflow.core.model.jdbc.ConnectionInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Desciption  数据连接通用类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 12:20
 */
@Slf4j
public class JdbcConnectionUtils {

    /**
     * 获取JDBC连接
     * @param conf
     * @return
     * @throws BussinessException
     */
    public static Connection jdbcConn(ConnectionInfo conf) throws BussinessException {
        Connection conn = null;

        try {
            Class.forName(conf.getClassName());
            conn = DriverManager.getConnection(conf.getJdbcUrl(), conf.getUsername(), conf.getPassword());
        } catch (SQLException e) {
            throw new BussinessException("连接失败.\n", e);
        } catch (ClassNotFoundException e) {
            throw new BussinessException("className获取失败.\n", e);
        }

        return conn;
    }

}
