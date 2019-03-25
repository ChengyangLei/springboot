package com.cloud.springboot.entity;

import java.util.List;

/**
 * @Description: R
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */

public class R  {
    private String retCode;
    private String retMsg;
    private Object retBean;
    private List<Object> retBeans;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetBean() {
        return retBean;
    }

    public void setRetBean(Object retBean) {
        this.retBean = retBean;
    }

    public List<Object> getRetBeans() {
        return retBeans;
    }

    public void setRetBeans(List<Object> retBeans) {
        this.retBeans = retBeans;
    }
}