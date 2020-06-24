package com.yingbing.designpatterns;

public class LazySingletonTest {
    public static void main(String[] args) {

        new Thread(() ->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() ->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

    }
}

class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){

    }

    public synchronized static LazySingleton getInstance() {
        if(instance == null){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}
