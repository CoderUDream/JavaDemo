package main.java;

import main.java.baseio.BaseIO;
import main.java.thread.TestThread;
import main.java.thread.TestThreadSync;
import main.java.thread.TestThreadLocal;
import main.java.thread.TestThreadAtom;
import main.java.thread.TestVolatile;

import main.java.reflection.TestReflect;

import main.java.annotation.TestAnnotation;

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