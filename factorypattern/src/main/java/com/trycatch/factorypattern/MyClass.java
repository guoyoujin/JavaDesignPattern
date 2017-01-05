package com.trycatch.factorypattern;

public class MyClass {

    public static void main(String[] args){
        Product apple= ProductFactory.createdApple();
        System.out.println(apple.getProduct());
        Product book = ProductFactory.createdBook();
        System.out.println(book.getProduct());
    }
}
