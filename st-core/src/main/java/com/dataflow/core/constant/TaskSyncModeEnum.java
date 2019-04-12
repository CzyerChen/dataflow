package com.dataflow.core.constant;

/**
 * Desciption:数据同步模式枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 10:38
 */
public enum TaskSyncModeEnum {
    DATABASEMODE("库级别"),
    TABLEMODE("表级别"),
    COLUMNMODE("列级别");

    private  String message;

    TaskSyncModeEnum(String msg){
        this.message = msg;
    }

    @Override
    public String toString(){
        return message;
    }

}
