package com.trycatch.factorypattern;

/**
 * 苹果类
 *
 * @FileName: com.trycatch.factorypattern.AppleInfo.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 15:39
 * @version: V1.0 <描述当前版本功能>
 */

public class Apple implements Product {

    @Override
    public Object getProduct() {
        return "我是苹果";
    }
    
}
