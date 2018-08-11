import baseio.BaseIO;
import thread.TestThread;
import thread.TestThreadSync;
import thread.TestThreadLocal;
import thread.TestThreadAtom;
import thread.TestVolatile;

import reflection.TestReflect;


public class TestMain {

    public void testIO() {
        BaseIO.fileReader();
        BaseIO.fileInputStream();
        BaseIO.fileOutputStream();
    }

    public void testThread() {
        TestThread.TestUseThread();
    }

    public void testSyncThread() {
        TestThreadSync.testThreadSync();
    }

    public void testThreadLocal() { TestThreadLocal.testThreadLocal(); }

    public void testThreadAtom() { TestThreadAtom.testThreadAtom(); }

    public void testThreadVolatile() { TestVolatile.testVolatile(); }

    public void testReflect() { TestReflect.testReflect(); }

    public static void main(String[] args) {
       TestMain t = new TestMain();
       //BaseCollections.TestCollections();
       //t.testIO();

       //t.testThread();
       //t.testSyncThread();
       //t.testThreadLocal();
        //t.testThreadAtom();
        //t.testThreadVolatile();

        t.testReflect();
    }
}