package com.trycatch.observer;

import java.io.Serializable;

/**
 * 在此写用途
 *
 * @FileName: com.trycatch.observer.TestBean.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 13:44
 * @version: V1.0 <描述当前版本功能>
 */

public class TestBean implements Serializable{
    public String name;
    public String msg;


    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
