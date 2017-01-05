package com.trycatch.observer;

/**
 * 在此写用途
 *
 * @FileName: com.trycatch.observer.MySubject.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 13:30
 * @version: V1.0 <描述当前版本功能>
 */

public class MySubject extends AbstractSubject {
    private String TAG = MySubject.class.getSimpleName();
    @Override
    public void operation() {
        System.out.println(TAG+" update self!");
        notifyObservers();
    }

    @Override
    public void operation(Object object) {
        System.out.println(TAG+" update self!");
        notifyObservers(object);
    }
}
