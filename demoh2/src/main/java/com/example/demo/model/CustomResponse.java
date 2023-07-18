package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CustomResponse {
     
    private String code;
    
    private String desc;
    
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomResponse() {
    }
    
    public void setSucccess()
    {
    	this.code = "0";
    	this.desc = "success";
    	this.msg = "Transaction is success";
    }
}

