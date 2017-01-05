package com.trycatch.factorypattern;

/**
 * 工厂类，提供的是静态方法
 *
 * @FileName: com.trycatch.factorypattern.ProductInfoFactory.java
 * @author: guoyoujin
 * @mail: guoyoujin123@gmail.com
 * @date: 2017-01-05 15:46
 * @version: V1.0 <描述当前版本功能>
 */

public class ProductFactory {
   public static Product createdApple(){
       return new Apple();
   }

    public static Product createdBook(){
        return new Book();
    }
}
