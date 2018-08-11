package thread;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;
import java.lang.StringBuffer;

/**
 * Created by Administrator on 2018/8/11.
 */

class ThreadC implements Runnable {

     // TnreadLocal一般用于类内部的静态变量 可以被多个类实例共享
     // 原理：每个线程独自拷贝一份该初始数据 互不影响
     static ThreadLocal<String> localA = new ThreadLocal<String>() { //匿名内部类

        @Override
        protected String initialValue() {
            return super.initialValue();
        }
    };

    ThreadC(String s) {
        localA.set(s);
        Thread.currentThread().setName(s);
    }


    @Override
    public void run() {
        String name = localA.get();
        System.out.println("thread-" + Thread.currentThread().getName() + " start...");
        for(int i = 1; i <= 50; i++) {
            localA.set(localA.get() + new Random().nextInt(10));
        }
        System.out.println("thread-" + Thread.currentThread().getName() + " localA is:" + localA.get());
    }
};


public class TestThreadLocal {

    public static void testThreadLocal() {


        new Thread(new ThreadC("a")).start();
        new Thread(new ThreadC("b")).start();
        new Thread(new ThreadC("c")).start();
    }
}
