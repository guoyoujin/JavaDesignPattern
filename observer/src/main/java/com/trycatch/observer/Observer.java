package com.trycatch.observer;

/**
 *所有观察者的接口 Observer 接口
 *
 * @FileName: com.trycatch.observer.Observer.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 12:18
 * @version: V1.0 <描述当前版本功能>
 */

public interface Observer {
    public void update();
    public void update(Object object);
}
