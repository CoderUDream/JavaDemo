import baseio.BaseIO;
import thread.TestThread;
import thread.TestThreadSync;
import thread.TestThreadLocal;
import thread.TestThreadAtom;
import thread.TestVolatile;

import reflection.TestReflect;

import annotation.TestAnnotation;

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

    public void testAnnotation() throws Exception { TestAnnotation.testAnnotation(); }

    public static void main(String[] args) {
        try {

       TestMain t = new TestMain();
       //BaseCollections.TestCollections();
       //t.testIO();

       //t.testThread();
       //t.testSyncThread();
       //t.testThreadLocal();
        //t.testThreadAtom();
        //t.testThreadVolatile();

        //t.testReflect();

        t.testAnnotation();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}