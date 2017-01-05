package com.trycatch.factorypattern;

/**
 * 书本类
 *
 * @FileName: com.trycatch.factorypattern.BookInfo.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 15:45
 * @version: V1.0 <描述当前版本功能>
 */

public class Book implements Product {
    @Override
    public Object getProduct() {
        return  "我是书本";
    }
}
