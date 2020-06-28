package com.yinbing.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerClassSingle> declaredConstructor = InnerClassSingle.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);

        InnerClassSingle innerClassSingle2 = declaredConstructor.newInstance();


        InnerClassSingle innerClassSingle1 = InnerClassSingle.getInstance();

        System.out.println(innerClassSingle1 == innerClassSingle2);
    }
}

/**
 * 利用类加载机制来保证线程安全
 *
 * 也是一种懒加载
 *
 */
class InnerClassSingle{
    private static class InnerClassSingleHolder{
        private static InnerClassSingle instance = new InnerClassSingle();
    }
    
    private InnerClassSingle(){
        if(InnerClassSingleHolder.instance != null){
            throw new RuntimeException("不允许有多个实例");
        }
    }

    public static InnerClassSingle getInstance() {
        return InnerClassSingleHolder.instance;
    }
    
}