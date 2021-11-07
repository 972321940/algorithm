package com.wuz11.test1;

public class sysout {
    private static sysout inst = null;

    public static sysout getInstance(){
        if(inst == null){
            inst = new sysout();

        }
        return inst;
    }

    public static void main(String[] args) {
        perr("111");
    }
    public static void perr(){
        System.err.println("！！！！！！！！！！！！");
        System.err.println();
        System.err.println("！！！！！！！！！！！！");
    }
    public static void perr(String a){
        System.err.println("！！！！！！！！！！！！");
        System.err.println(a);
        System.err.println("！！！！！！！！！！！！");
    }
}
