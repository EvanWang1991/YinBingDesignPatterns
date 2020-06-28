package com.yinbing.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingleton {
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}

class EnumSingletonTest{
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;

        System.out.println(instance1 == instance2);

        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);

        declaredConstructor.setAccessible(true);

        EnumSingleton enumSingleton = declaredConstructor.newInstance();
    }
}
