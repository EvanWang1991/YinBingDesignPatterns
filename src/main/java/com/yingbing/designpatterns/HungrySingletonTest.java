package com.yingbing.designpatterns;

public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}

class HungrySingleton{
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
