# Java Observer
顾命思义，这是java的观察者模式下面简单介绍

##摘要：
观察者模式（ObserverPattern）。用于实时监测某些Object的动态、只要Object一改变、那么他的所有观察者Observer都会知道、之后观察者会根据Object的改变进行下一步操作。这个在Android编程中是最常见的。那些Listener就是观察者。

####一：问题的引出
    假如要实现这样一个功能：
    老师要通知所有学生一条消息，每个学生都能收到，并且可以选择不通知谁，或只通知谁
    
####二：模型设计
     1、通过分析我们得出一个简单的总结：就是一旦老师有消息通知学生，那么我们就通知相应的学生，观察者模式可以很好的解决这个问题。
     
     2、确定谁是观察者，谁是被观察者
     
     3、根据需求我们可以抽象出两个接口
          (1)所有被观察者的接口 ——   Subject；
        
          (2)所有观察者的接口  ——    Observer；
          
     4、对于Subject当然要拥有三个关于操作Observer的方法、注册、移除、和通知Observer的方法（观察者肯定要和被观察者结合起来）。
        对于Observer肯定要有一个update方法、就是一旦检测到Subject有变动、就更新信息。
        
 
####三：具体代码实现
 1、设计Subject接口：
```java
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
```
   
2、设计Observer接口：
```java
public interface Observer {
   public void update();
   public void update(Object object);
}
```

3、设计AbstractSubject抽象类让他实现Subject接口：
```java
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
```

4、设计具体的实现AbstractSubject的被观察者MySubject:
```java
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
```


5、接下来就是实现我们的观察者Observer的具体实现:
```java
public class ObserverFirst implements Observer{
    private String TAG = ObserverFirst.class.getSimpleName();
    @Override
    public void update() {
        System.out.println(TAG+" Messages are received");
    }

    @Override
    public void update(Object object) {
        System.out.println(TAG+" Messages is ==>>"+object.toString());
    }
}
```


```java
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
```

```java
public class ObserverThree implements Observer{
    private String TAG = ObserverThree.class.getSimpleName();
    @Override
    public void update() {
        System.out.println(TAG+" Messages are received");
    }

    @Override
    public void update(Object object) {
        System.out.println(TAG+" Messages is ==>>"+object.toString());
    }

```

6、有了观察者和被观察者基本就能实现我们所要求的了:
```java
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
```

输出结果
```java
=======register observer start
MySubject update self!
ObserverFirst Messages are received
ObserverSecond Messages are received
ObserverThree Messages are received
=======register observer end
=======remove observer  start
MySubject update self!
ObserverFirst Messages are received
ObserverSecond Messages are received
=======remove observer start
=======register observer add params start
MySubject update self!
ObserverFirst Messages is ==>>TestBean{name='老师发来的消息', msg='你们要来上课了啊'}
ObserverSecond Messages is ==>>TestBean{name='老师发来的消息', msg='你们要来上课了啊'}
ObserverThree Messages is ==>>TestBean{name='老师发来的消息', msg='你们要来上课了啊'}
=======register observer add params end

Process finished with exit code 0
```