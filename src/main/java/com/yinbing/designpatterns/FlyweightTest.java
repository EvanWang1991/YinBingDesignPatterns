package com.yinbing.designpatterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 * 首先常规操作，我们先看一下什么是享元模式，维基百科解释：享元模式（英语：
 * Flyweight Pattern）是一种软件设计模式。它使用共享物件，用来尽可能减少
 * 内存使用量以及分享资讯给尽可能多的相似物件；它适合用于当大量物件只是
 * 重复因而导致无法令人接受的使用大量内存。通常物件中的部分状态是可以分
 * 享。常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元。
 * 关键字：减少内存，共享物件，外部数据
 * 简单点描述一下就是一批对象中既有相同的内容也有不同的内容，相同的内容采
 * 用共享的方式，不同的内容通过动态传递的方式，来尽量减少对象的产生。这里
 * 需要理解的一点是，这多个对象其实底层对应的是同一个对象，物理地址是一
 * 个。
 * 享元模式使用场景
 *
 * 享元模式的使用场景还是比较多的，最常见的一个场景就是 Java JDK 里面的
 * String 字符串类，因为 JVM 中有常量池，常量池的实现就是一种享元模式，避
 * 免多个相同对象的存在。另外线程池以及很多用到缓冲池的地方都采用了享元模
 * 式，比如 Integer 类中默认缓存了[-128-127] 之间的整数，等等场景。
 * 在演示享元模式之前，我们要先了解享元模式中涉及到的几个角色名称
 * 1. 抽象享元类：通常是一个接口，主要对外提供修改内部数据的接口
 * 2. 具体享元类：享元的实现类，通常存储在内存中，便于使用
 * 3. 享元工厂类：对外创建具体享元类
 *
 * @Auther: Jixiang.Wang
 * 峥嵘岁月 何惧风流
 */
public class FlyweightTest {
    public static void main(String[] args) {
        BookFactory.getBook("三国演义","罗贯中");
        BookFactory.getBook("水浒传","施耐庵");
        BookFactory.getBook("三国演义","罗贯中");
    }
}

class BookFactory{
    private static Map<String, Book> bookPool = new ConcurrentHashMap<>();

    public static Book getBook(String name, String auther){
        Book result;
        result = bookPool.get(name);
        if(result == null){
            result = new Book(name, auther);
            bookPool.put(name, result);
        }
        return result;
    }
}

class Book{
    private final String bookName;
    private final String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        downloadBook(bookName);
    }

    private void downloadBook(String bookName){
        System.out.println("下载新书："+ bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }
}
