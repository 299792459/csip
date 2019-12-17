package com.csi.csi_demo.utils;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/18 0018
 * @since 1.0.0
 */
public class CsiResult implements Serializable {

    private static final long serialVersionUID=1802410;

    //返回的对象
    Object resultObject;
    //返回的信息
    String message;
    //返回状态吗，1是成功，0是失败
    int status;

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
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

    public CsiResult(){}

    public CsiResult(Object resultObject, String message, int status) {
        this.resultObject = resultObject;
        this.message = message;
        this.status = status;
    }
}
