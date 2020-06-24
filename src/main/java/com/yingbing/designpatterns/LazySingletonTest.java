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
    //防止指令重排
    private static volatile LazySingleton instance;
    private LazySingleton(){

    }

    public static LazySingleton getInstance() {
        if(instance == null){
            synchronized (LazySingleton.class){
                //double check
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
