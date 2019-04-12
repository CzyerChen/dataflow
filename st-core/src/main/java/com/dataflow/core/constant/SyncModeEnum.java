package com.dataflow.core.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Desciption  异步枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 14:48
 */
public enum SyncModeEnum {
    //库级别
    DB_ORDERED_GLOBAL,
    //表级别
    TABLE_ORDERED_PARTLY,
    //列级别
    TABLE_COLUMN_PARTYLY;

    public static List<SyncModeEnum> getAllModes() {
        return Lists.newArrayList(DB_ORDERED_GLOBAL, TABLE_ORDERED_PARTLY,TABLE_COLUMN_PARTYLY);
    }
}
