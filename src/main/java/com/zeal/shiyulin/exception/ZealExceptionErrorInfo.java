package com.zeal.shiyulin.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ZealExceptionErrorInfo {
    private String code;
    private String message;
    private String data;

    public ZealExceptionErrorInfo(Exception ex){
        this.code = "error";
        if (ex != null) {
            this.message = ex.getLocalizedMessage();
        }
        this.data = null;
    }
    public ZealExceptionErrorInfo(String message, String data) {
        this.code = "error";
        this.message = message;
        this.data = data;
    }

    public ZealExceptionErrorInfo(String message, Exception ex) {
        this.code = "error";
        this.message = message;
        if (ex != null) {
            this.data = ex.getLocalizedMessage();
        }
    }

    public ZealExceptionErrorInfo(String message, Exception ex, String code) {
        this.message = message;
        this.code = code;
        if (ex != null) {
            this.data = ex.getLocalizedMessage();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setException(String exception) {
        this.data = exception;
    }

    @JsonInclude(Include.NON_NULL)
    public String getException() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
