package com.example.SpringBeginner.dtobai1;

public class ResultResponse {
    private int status;
    private Boolean result;

    public ResultResponse() {
    }

    public ResultResponse(int status, Boolean result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
