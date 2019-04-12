package com.dataflow.core.model.message;

import java.io.Serializable;

/**
 * Desciption  传输信息抽象类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 17:26
 */
public abstract class AbstractMessage<T> implements Serializable{
    protected T id;
    protected String databaseName;
    protected String tableName;


    public T getId(){
        return this.id;
    }

    public void setId(T id){
        this.id = id;
    }
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
