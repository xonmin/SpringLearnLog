package com.example.study.model.entity;

import org.junit.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

    public static final Singleton Instance = new Singleton();

    private Singleton() {
        if (Instance != null) {
            throw new RuntimeException("Singleton CLASS");
        }

    }

    ;


    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton1 = Singleton.Instance;
        Singleton singleton2 = Singleton.Instance;


        Constructor<Singleton> constructor = (Constructor<Singleton>) singleton2.getClass()
                .getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton3 = constructor.newInstance();


        Assert.assertEquals(singleton2, singleton3); //fail


    }
}

