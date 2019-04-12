package com.dataflow.common.model;

import com.dataflow.common.constant.HttpResponseConstant;

import java.io.Serializable;

/**
 * Desciption  接口返回值封装类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 25 17:27
 */
public class ApiResponse extends AbstractResponse implements Serializable {

    public Object data;

    public static class Builder {
        private Long code;
        private String responseMessage;
        private Object data;

        public ApiResponse.Builder code(Long code){
            this.code = code;
            return this;
        }
        public ApiResponse.Builder responseMessage(String responseMessage){
            this.responseMessage = responseMessage;
            return  this;
        }
        public ApiResponse.Builder data(Object data){
            this.data = data;
            return  this;
        }

        public ApiResponse build() {
            return new ApiResponse(this.code, this.responseMessage, this.data);
        }

    }

    public static ApiResponse success(){
        return new ApiResponse(HttpResponseConstant.SUCCESS_CODE,HttpResponseConstant.SUCCESS_MSG);
    }

    public static ApiResponse success(Object data){
        return new ApiResponse(HttpResponseConstant.SUCCESS_CODE,HttpResponseConstant.SUCCESS_MSG,data);
    }

    public static ApiResponse internalError(){
        return new ApiResponse(HttpResponseConstant.INTERNAL_SERVER_ERROR_CODE,HttpResponseConstant.INTERNAL_SERVER_ERROR_MSG);
    }

    public static ApiResponse fail(Long code, String message){
        return new ApiResponse(code,message);
    }


    public ApiResponse(Long code, String responseMessage, Object data) {
        super(code, responseMessage);
        this.data = data;
    }

    public ApiResponse(Long code, String responseMessage) {
        super(code, responseMessage);
    }

    public static ApiResponse.Builder builder() {
        return new ApiResponse.Builder();
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCode() {
        return code;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public Object getData() {
        return data;
    }
}
