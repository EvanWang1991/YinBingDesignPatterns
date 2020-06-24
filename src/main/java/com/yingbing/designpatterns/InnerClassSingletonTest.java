package com.yingbing.designpatterns;

public class InnerClassSingletonTest {

    public static void main(String[] args) {

        InnerClassSingle instance1 = InnerClassSingle.getInstance();
        InnerClassSingle instance2 = InnerClassSingle.getInstance();

        System.out.println(instance1 == instance2);

    }
}

class InnerClassSingle{
    private static class InnerClassSingleHolder{
        private static InnerClassSingle instance = new InnerClassSingle();
    }
    
    private InnerClassSingle(){}

    public static InnerClassSingle getInstance() {
        return InnerClassSingleHolder.instance;
    }
    
}