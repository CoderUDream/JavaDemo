import baseio.BaseIO;
import collections.BaseCollections;

public class TestMain {

    public void testIO() {
        BaseIO.fileReader();
        BaseIO.fileInputStream();
        BaseIO.fileOutputStream();
    }


    public static void main(String[] args) {
       TestMain t = new TestMain();
       BaseCollections.TestCollections();
       //t.testIO();
    }
}