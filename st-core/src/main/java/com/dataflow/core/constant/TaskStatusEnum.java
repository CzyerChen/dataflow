package com.dataflow.core.constant;

/**
 * Desciption  任务状态枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 12:51
 */
public enum TaskStatusEnum {
    STOPPED(0),
    PAUSED(1),
    RUNNING(2),
    CANCELED(3);

    private  int statusNum;

    TaskStatusEnum(int statusNum){
        this.statusNum = statusNum;
    }

    public int getStatusNum(){
        return this.statusNum;
    }

}
