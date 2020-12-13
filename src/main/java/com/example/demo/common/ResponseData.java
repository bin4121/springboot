package com.example.demo.common;


public class ResponseData<T> {

    public ResponseData() {
        this(200, "success");
    }

    public ResponseData(T data) {
        this(200, "success");
        this.data = data;
    }
    public ResponseData(T data,Integer code) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



    private Integer code = 200;

    private String message = "";

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
