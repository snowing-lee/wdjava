/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 14:46
 */
package com.cskaoyan.wdjava.util;

public class Result {

    private boolean ret;

    private Object data;

    private String failMsg;

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
