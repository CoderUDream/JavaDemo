package thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/8/10.
 */

class SynchronziedStaticAddThread implements Runnable {

    @Override
    public void run() {
        DataOperation.add();
    }
}

class SynchronziedStaticGetThread implements Runnable {

    @Override
    public void run() {
        System.out.println("SynchronziedGetThread run get");
        String value = DataOperation.get(1);
        System.out.println("SynchronziedGetThread get value:" + value);
    }
}

//数据操作类
class DataOperation {

    static ConcurrentHashMap<Integer, String> static_map = new ConcurrentHashMap<Integer, String>();
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
    //增加数据
    public synchronized static void add() {

        static_map.put(1, "2");
        try {
            System.out.println("synchronized static void add put finish");
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    //取数据
    public synchronized static String get(int key) {
        System.out.println("synchronized static void add get enter");
        return static_map.get(key);
    }
}


public class TestThreadSync {

    public void testStaticSync() {
        new Thread(new SynchronziedStaticAddThread()).start();

        for(int i = 1; i <= 10; i++) {
            new Thread(new SynchronziedStaticGetThread()).start();
        }
    }

    public static void testThreadSync() {
        TestThreadSync t = new TestThreadSync();
        t.testStaticSync();
    }
}
