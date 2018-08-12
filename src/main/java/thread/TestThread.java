package main.java.thread;

/**
 * Created by Administrator on 2018/8/10.
 */

//继承Thread
class ThreadA extends Thread {

    public int i = 1;

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println("A:" + i);
        }
    }
}

//实现Runnable接口
class ThreadB implements Runnable {

    public int i = 1;

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println("B:" + i);
        }
    }
}

public class TestThread {

    public void testExtendsThread() {
        Thread a = new ThreadA();
        a.start();

        Thread b = new Thread(new ThreadB());
        b.start();
    }

    //测试join
    public void testJoinThread() {
        Thread a = new ThreadA();
        a.start();
        try {
            System.out.println("main start---");
            a.join();
            System.out.println("main end---");
        }
        catch(InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    //测试yield
    public void testYieldThread() {

        Thread a = new ThreadA();
        a.start();

        Thread b = new ThreadA();
        b.start();

        Thread c = new ThreadA();
        c.start();

        System.out.println("main start---");
        Thread.yield(); //调用其他runnable的线程，自己暂停

        System.out.println("main end---");
    }

    //测试interrupted
    public void testInterruptedTread() {
        Thread a = new Thread(new Runnable() {

            int i = 1;
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                }
            }
        });
        a.start();

        Thread b = new Thread(new Runnable() {

            int i = 1;
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("threa b call a interrupt!");
                    a.interrupt();
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        });
        b.start();
    }

    //测试守护进程
    public void testDaemonThread() {
        Thread a = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    //这里并不会一直循环下去，当用户线程结束后，守护进程将结束
                    while(true) {
                        System.out.println("daemon start working");
                        Thread.sleep(1000);
                        System.out.println("daemon end working");
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        });
        a.setDaemon(true);
        a.start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        Thread.sleep(2000);
                        System.out.println("main.java.thread running ~~ ");
                    }
                }
                catch(InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        }).start();
    }

    //测试wait和notify
    public void testWaitAndNotify() {
        Object obj = new Object();
        Thread a = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("start and waitting obj...");
                    //等待obj的notify才会继续执行,  必须先获取到obj的锁，并且锁住obj
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("get the obj...");
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        });
        a.start();
        try {
            //休眠2秒
            Thread.sleep(3000);
            //通知再wait obj的线程
            System.out.println("notify obj...");
            //必须先获取到obj的锁，并且锁住obj
            synchronized (obj) {
                obj.notify();
            }
        }catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }


    public static void TestUseThread() {
        TestThread t = new TestThread();
        //t.testExtendsThread();
        //t.testJoinThread();
        //t.testYieldThread();
        t.testDaemonThread();
        //t.testInterruptedTread();
        //t.testWaitAndNotify();
    }
}
