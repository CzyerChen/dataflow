package com.dataflow.common.model;

/**
 * Desciption  接口层异常类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 26 13:04
 */
public class ApiException extends BussinessException {


    public ApiException(Long code,String message,Object data,Throwable e){
        super(code, message, data, e);
    }
    public ApiException(Long code,String message,Object data){
        this(code,message,data,null);
    }

    public ApiException(Long code,String message){
        this(code,message,null,null);
    }

    public ApiException(String message,Throwable e){
        super(message,e);
    }
    public ApiException(Throwable e){
        super(e);
    }

    public ApiException(){

    }

}
