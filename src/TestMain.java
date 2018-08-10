import baseio.BaseIO;
import collections.BaseCollections;
import thread.TestThread;
import  thread.TestThreadSync;

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

    public static void main(String[] args) {
       TestMain t = new TestMain();
       //BaseCollections.TestCollections();
       //t.testIO();

       //t.testThread();
       t.testSyncThread();

    }
}