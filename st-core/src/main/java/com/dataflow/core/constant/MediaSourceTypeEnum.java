package com.dataflow.core.constant;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * Desciption:数据源类型
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 15:19
 */
public enum MediaSourceTypeEnum {
    MYSQL, SQLSERVER, ORACLE, HDFS, HBASE, POSTGRESQL;

    public boolean isRdbms() {
        if (MYSQL.equals(this) || SQLSERVER.equals(this) || ORACLE.equals(this) || POSTGRESQL.equals(this)) {
            return true;
        }
        return false;
    }

    public static List<MediaSourceTypeEnum> getAllSrcMediaSourceTypes() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE, POSTGRESQL);
    }

    public static List<MediaSourceTypeEnum> getTargetTypesForRDBMS() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE,  POSTGRESQL);
    }

    public static List<MediaSourceTypeEnum> getTargetTypesForHDFS() {
        return Lists.newArrayList(MYSQL, SQLSERVER, HDFS, HBASE,  POSTGRESQL);
    }

    public static List<MediaSourceTypeEnum> getTargetTypesForHBASE() {
        return Lists.newArrayList(HDFS, HBASE, POSTGRESQL);
    }

}
