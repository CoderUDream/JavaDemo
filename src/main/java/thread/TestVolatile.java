package main.java.thread;

/**
 * Created by Administrator on 2018/8/11.
 */
class ClassTestA {
    int number = 0;

    public void testNoVolatile() {

        for(int i = 1; i < 100; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println(e.toString());
                        }

                        System.out.println("main.java.thread-" + Thread.currentThread().getName() + " number is: " + number);
                    }
                }
            });
            t1.start();
        }

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        number++;
                        System.out.println("main.java.thread-" + Thread.currentThread().getName() + " changed number!!!!!!!!! new number is:" + number);
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                }
            }
        });
        t2.start();

    }
}


public class TestVolatile {

    public static void testVolatile() {
        ClassTestA a = new ClassTestA();
        a.testNoVolatile();
    }
}