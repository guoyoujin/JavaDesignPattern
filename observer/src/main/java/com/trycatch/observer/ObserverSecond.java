package com.trycatch.observer;

/**
 * 在此写用途
 *
 * @FileName: com.trycatch.observer.ObserverSecond.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 13:27
 * @version: V1.0 <描述当前版本功能>
 */

public class ObserverSecond implements Observer {
    private String TAG = ObserverSecond.class.getSimpleName();
    @Override
    public void update() {
        System.out.println(TAG+" Messages are received");
    }

    @Override
    public void update(Object object) {
        System.out.println(TAG+" Messages is ==>>"+object.toString());
    }
}
