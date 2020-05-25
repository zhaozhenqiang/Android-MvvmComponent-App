package com.fhzn.db1.home.sample.bean;

import java.util.ArrayList;

/**
 * reated by zhaozq on 2020/5/25.
 */
public class SampleWrapper {

    private ArrayList<SampleBean> result;
    private String message;
    private int status;

    public ArrayList<SampleBean> getResult() {
        return result;
    }

    public void setResult(ArrayList<SampleBean> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
