package com.trycatch.observer;

/**
 *所有被观察者的接口 Subject 接口
 *
 * @FileName: com.trycatch.observer.Subject.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 12:17
 * @version: V1.0 <描述当前版本功能>
 */

public interface Subject {
    
    /**
     * 注册观察者
     */
    public void registerObserver(Observer observer);

    /**
     * 删除观察者
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    public void notifyObservers();

    /**
     * 通知所有的观察者
     * @param object
     */
    public void notifyObservers(Object object);

    
    /**
     * 自身的操作
     */
    public void operation();

    /**
     * 自身的操作带参数
     */
    public void operation(Object object);

}
