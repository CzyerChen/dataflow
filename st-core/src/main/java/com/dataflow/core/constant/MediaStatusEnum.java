package com.dataflow.core.constant;

/**
 * Desciption:机器源状态枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 10:19
 */
public enum MediaStatusEnum {
    NORMAL("正常"),
    READYFORCHECKING("待检测"),
    ERROR("异常");

    private String message;

    MediaStatusEnum(String msg){
        this.message = msg;
    }
    @Override
    public String toString(){
        return message;
    }

}
