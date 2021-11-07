package com.wuz11.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test34 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        sysout.perr("123");
        // 你需要的class
        String classname = "com.wuz11.test1.sysout";
        String methodname = "perr";

        Class<?> clazz = Class.forName(classname);
        // invoke empty constructor
        Object object = clazz.getDeclaredConstructor().newInstance();
        Method setNameMethod = object.getClass().getMethod(methodname, String.class);
        // pass arg
        setNameMethod.invoke(object, "Mishka");
    }

}
