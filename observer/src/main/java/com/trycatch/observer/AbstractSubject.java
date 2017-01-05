package com.trycatch.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 在此写用途
 *
 * @FileName: com.trycatch.observer.AbstractSubject.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 13:18
 * @version: V1.0 <描述当前版本功能>
 */

public abstract class AbstractSubject implements Subject{

    private Vector<Observer> vector = new Vector<Observer>();


    @Override
    public void registerObserver(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }

    @Override
    public void notifyObservers(Object object) {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update(object);
        }
    }
}
