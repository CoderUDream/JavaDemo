package thread;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/8/11.
 */


class ThreadNoAtom implements Runnable {

    static int ticket = 100;

    @Override
    public void run() {

        while(ticket > 0) {
            try {
                ticket--;
                Thread.sleep(10);
                System.out.println("thread-" + Thread.currentThread().getName() + ", sell ticket:" + ticket);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }

        }
    }
}


class ThreadAtom implements Runnable {

    static AtomicInteger ticket = new AtomicInteger(100);

    @Override
    public void run() {
        try {
            while (true) {
                int count = 0;
                if ((count = ticket.get()) > 0) {
                    Thread.sleep(10);
                    //如果设置成功了，才打印
                    if (ticket.compareAndSet(count, count - 1)) {
                        System.out.println("thread-" + Thread.currentThread().getName() + ", sell ticket:" + (count - 1));
                    } else {
                        System.out.println("thread-" + Thread.currentThread().getName() + ", sell ticket failed");
                    }
                } else {
                    break;
                }
            }
        } catch(InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}

public class TestThreadAtom {

    public void testNoAtom() {
        for (int i = 1; i <= 3; i++) {
            new Thread(new ThreadNoAtom()).start();
        }
    }

    public void testAtom() {
        for (int i = 1; i <= 3; i++) {
            new Thread(new ThreadAtom()).start();
        }
    }

    public static void testThreadAtom() {
        TestThreadAtom t = new TestThreadAtom();
        //t.testNoAtom();
        t.testAtom();
    }
}
