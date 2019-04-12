package com.dataflow.core.constant;

/**
 * Desciption  数据操作枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 10:02
 */
public enum RdbmsOperationEnum {
    DATABASE_CREATE("创建数据库"),
    TABLE_CREATE("创建表"),
    TABLE_DUMP("删除表"),
    TABLE_ALTER("修改表"),
    TABLE_INSERT("插入数据"),
    TABLE_UPDATE("修改数据"),
    TABLE_DELETE("删除数据");


    private String message;
    RdbmsOperationEnum(String message){
      this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
