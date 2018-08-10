package thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/8/10.
 */

//测试synchronzied用于静态类方法
class SynchronziedStaticPutThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedStaticPutThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        dataOpt.put();
    }
}

class SynchronziedStaticGetThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedStaticGetThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        System.out.println("SynchronziedStaticGetThread run get");
        String value = dataOpt.get(1);
        System.out.println("SynchronziedStaticGetThread get value:" + value);
    }
}


//测试synchronzied用于普通成员方法
class SynchronziedPutThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedPutThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        dataOpt.notStaticPut();
    }
}

class SynchronziedGetThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedGetThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        System.out.println("SynchronziedGetThread run get");
        String value = dataOpt.notStaticGet(1);
        System.out.println("SynchronziedGetThread get value:" + value);
    }
}

//测试synchronzied用于代码块方法
class SynchronziedChunkPutThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedChunkPutThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        dataOpt.chunkPut();
    }
}

class SynchronziedChunkGetThread implements Runnable {

    DataOperation dataOpt;

    SynchronziedChunkGetThread(DataOperation dataOpt) {
        this.dataOpt = dataOpt;
    }

    @Override
    public void run() {
        System.out.println("SynchronziedChunkGetThread run get");
        String value = dataOpt.chunkGet(1);
        System.out.println("SynchronziedChunkGetThread get value:" + value);
    }
}

//数据操作类
class DataOperation {

    static ConcurrentHashMap<Integer, String> static_map = new ConcurrentHashMap<Integer, String>();
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

    //静态  增加数据
    public synchronized static void put() {

        static_map.put(1, "2");
        try {
            System.out.println("synchronized static void put finish");
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    //静态  取数据
    public synchronized static String get(int key) {
        System.out.println("synchronized static String get enter");
        return static_map.get(key);
    }

    //函数 增加数据
    public synchronized void notStaticPut() {
        map.put(1, "2");
        try {
            System.out.println("synchronized void notStaticAdd finish");
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    //函数 取数据
    public synchronized String notStaticGet(int key) {
        System.out.println("synchronized String notStaticGet enter");
        return map.get(key);
    }

    //代码块 增加数据
    public  void chunkPut() {
        synchronized (map) {
            map.put(1, "2");
        }
        try {
            System.out.println("synchronized void chunkPut finish");
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    //取数据
    public  String chunkGet(int key) {
        synchronized (map) {
            System.out.println("synchronized String chunkGet enter");
        }
        return map.get(key);
    }

    //输出文字
    public synchronized void print() {
        System.out.println("DataOperation print nothings...");
    }
}


public class TestThreadSync {

    //测试synchronzied用于类静态方法
    public void testStaticSync() {
        DataOperation dataOpt1 = new DataOperation();
        new Thread(new SynchronziedStaticPutThread(dataOpt1)).start();

        DataOperation dataOpt2 = new DataOperation(); //用不同的data对象
        for(int i = 1; i <= 10; i++) {
            new Thread(new SynchronziedStaticGetThread(dataOpt2)).start();
        }
    }

    //测试synchronzied用于类非静态方法
    public void testCommFunctionSync() {
        DataOperation dataOpt1 = new DataOperation();
        new Thread(new SynchronziedPutThread(dataOpt1)).start();

        //用相同对象，将会阻塞
        for(int i = 1; i <= 10; i++) {
            new Thread(new SynchronziedGetThread(dataOpt1)).start();
        }

        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

        //测试调用对象的别的synchronized函数会阻塞  原因：synchronized会锁住整个对象 所有的synchronized都会被锁住
        new Thread(new Runnable() {

            DataOperation dataOpt;

            @Override
            public void run() {
                dataOpt1.print();
            }
        }).start();


        DataOperation dataOpt2 = new DataOperation(); //用不同的data对象，将不会阻塞
        for(int i = 1; i <= 10; i++) {
            new Thread(new SynchronziedGetThread(dataOpt2)).start();
        }
    }

    //测试synchronzied用于方法中的代码块
    public void testChunkSync() {

    }

    public static void testThreadSync() {
        TestThreadSync t = new TestThreadSync();
        //t.testStaticSync();
        t.testCommFunctionSync();
    }
}
