package com.dataflow.common.model;

/**
 * Desciption  普通返回值
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 11 13:13
 */
public class CommonResponse extends AbstractResponse {

    public CommonResponse(Long code ,String message) {
        super(code,message);
    }

    public Long getCode(){
        return this.code;
    }

    public String getMessage(){
        return  this.responseMessage;
    }

}
