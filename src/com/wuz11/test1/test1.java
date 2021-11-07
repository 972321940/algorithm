package com.wuz11.test1;

public class test1 {
    /**
     * 兔子问题
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少
     */
    public static void main(String[] args) {
        for (int month = 1; month <= 20; month++) {
            System.err.println("兔子第"+month+"月总数为："+old(month));
        }
    }

    /**
     * 兔子的规律为数列1,1,2,3,5,8,13,21....
     *
     * @param month
     * @return
     */
    public static int old(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else{
            return old(month - 1) + old(month - 2);
        }
    }
}
