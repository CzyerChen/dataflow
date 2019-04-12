package com.dataflow.common.model;

/**
 * Desciption 功能异常类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 13:13
 */
public class BussinessException extends RuntimeException {
    private Long code;
    private Object data;

    public BussinessException() {

    }

    public BussinessException(Throwable e) {
        super(e);
    }

    public BussinessException(String message, Throwable e) {
        super(message, e);
    }

    public BussinessException(String message){
        super(message);
    }

    public  BussinessException(Long code,String message,Object data,Throwable e){
        super(message,e);
        this.code = code;
        this.data = data;
    }
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
