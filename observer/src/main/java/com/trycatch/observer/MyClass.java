package com.trycatch.observer;

public class MyClass {
    public static void main(String[] args){
        System.out.println("=======register observer start");
        MySubject mySubject = new MySubject();
        mySubject.registerObserver(new ObserverFirst());
        mySubject.registerObserver(new ObserverSecond());
        mySubject.registerObserver(new ObserverThree());
        mySubject.operation();
        System.out.println("=======register observer end");


        System.out.println("=======remove observer  start");
        MySubject mySubject2 = new MySubject();
        ObserverFirst observerFirst = new ObserverFirst();
        ObserverSecond observerSecond = new ObserverSecond();
        ObserverThree observerThree = new ObserverThree();
        mySubject2.registerObserver(observerFirst);
        mySubject2.registerObserver(observerSecond);
        mySubject2.registerObserver(observerThree);
        mySubject2.removeObserver(observerThree);
        mySubject2.operation();
        System.out.println("=======remove observer start");

        
        System.out.println("=======register observer add params start");
        MySubject mySubject3 = new MySubject();
        mySubject3.registerObserver(new ObserverFirst());
        mySubject3.registerObserver(new ObserverSecond());
        mySubject3.registerObserver(new ObserverThree());
        TestBean testBean = new TestBean();
        testBean.setName("老师发来的消息");
        testBean.setMsg("你们要来上课了啊");
        mySubject3.operation(testBean);
        System.out.println("=======register observer add params end");

    }
}
