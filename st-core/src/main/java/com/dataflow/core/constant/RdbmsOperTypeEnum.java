package com.dataflow.core.constant;

/**
 * Desciption  数据同步类型枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 10:10
 */
public enum RdbmsOperTypeEnum {
    DML("表数据操作"),
    DDL("表结构操作"),
    DCL("用户权限操作");
    private String message;

    RdbmsOperTypeEnum(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return this.message;
    }
}
