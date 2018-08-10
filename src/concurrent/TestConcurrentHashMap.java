package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/8/9.
 */
public class TestConcurrentHashMap {

    public static void testUse() {
        ConcurrentHashMap<Integer, String> hm = new ConcurrentHashMap<Integer, String>();
        hm.put(1, "2");

    }

    public static void TestConcurrentHashMap() {
        TestConcurrentHashMap bc = new TestConcurrentHashMap();
        //bc.testList();
        //bc.testHashSetAndTreeSet();
        //bc.testMap();
        bc.testUse();
    }
}
