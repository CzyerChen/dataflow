package com.dataflow.common.model;

/**
 * Desciption 顶层抽象返回类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 13:11
 */
public abstract class AbstractResponse {
    public Long code;
    public String responseMessage;

    AbstractResponse(Long code,String responseMessage){
        this.code = code;
        this.responseMessage = responseMessage;
    }

    AbstractResponse(Long code){
        this.code = code;
    }


}
