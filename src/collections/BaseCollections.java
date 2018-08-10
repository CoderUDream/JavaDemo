package collections;

/**
 * Created by liyujiang on 2018/8/9.
 */

import java.util.*;


public class BaseCollections {



    /***********Set接口********************/
    //测试HashSet TreeSet
    //HashSet是使用散列表进行存储，元素无序，元素允许为null。
    //TreeSet是使用树结构来进行存储，元素按字符串顺序排序存储，元素不允许为null。

    //HashSet底层使用HashMap实现
    //TreeSet底层使用TreeMap实现

    public void testHashSetAndTreeSet() {
        // HashSet
        Set<Integer> hs = new HashSet<Integer>();
        // 插入
        for(int i = 1; i <= 10; i++) {
            hs.add(i); //等于v.addElement(i);
        }
        //遍历 调用Collections的接口
        Iterator<Integer>  it = hs.iterator();
        while(it.hasNext()) {
            System.out.print(String.valueOf(it.next()) + ",");
        }

        //TreeSet
        Set<Integer> ts = new TreeSet<Integer>();
        System.out.print("\n");
    }





    /**********List接口********************/

    //ArrayList和LinkedList区别
    //ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构

    //Vector也是基于动态数组的数据结构
    //Vector与ArrayList区别：
    //1.Vector是线程安全的，而ArrayList为非线程安全
    //2.当两者元素超过初始大小的时候，Vector容量会翻倍，而ArrayList只会增长50%


    //Vector
    public void testList() {
        Vector<Integer> v = new Vector<Integer>();

        //插入
        for(int i = 1; i <= 10; i++) {
            v.add(i); //等于v.addElement(i);
        }

        //根据枚举遍历 也可根据下标遍历
        v.add(0, 0); //按照指定的位置插入
        Enumeration<Integer> enumV = v.elements();
        while(enumV.hasMoreElements()) {
            System.out.print(String.valueOf(enumV.nextElement()) + ",");
        }

        //使用Collections排序
        Collections.sort(v, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //遍历 调用Collections的接口
        Iterator<Integer>  it = v.iterator();
        while(it.hasNext()) {
            System.out.print(String.valueOf(it.next()) + ",");
        }
        System.out.print("\n");
    }


    /**********Map接口********************/
    /*   1.HashMap
     *   HashTable
     *   TreeMap
     *
     *   1.HashMap
     */

    //简单使用
    public void testMap() {
        Map<Integer, String> hm = new HashMap<Integer, String>();
        for(int i = 1; i <= 10; i++) {
            hm.put(i, String.valueOf(i)); //等于v.addElement(i);
        }

        //删除元素
        System.out.println(hm.remove(1));

        //遍历
        for (Map.Entry<Integer, String> entry: hm.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }

        //通过values获取 HashMap里面的Value类的ValueIterator
        Collection<String> c = hm.values();
        Iterator<String> ithm = c.iterator();
        while(ithm.hasNext()) {
            System.out.println(ithm.next());
        }
        //HashTable，TreeMap与HashMap使用方法类似
    }

    //HashMap与HashTable区别
    //1. HashMap线程不安全的，HashTable是线程安全的，所以效率少HashMap高
    //2. HashMap允许放空值，而HashTable不允许
    //3. HashTable已经被淘汰，如果在线程安全的地方请使用HashMap，不安全请使用ConcurrentHashMap
    public void diffHashMapAndHashTable() {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

        //测试放空值
        hm.put(null, "123");
        hm.put(null, "1234");
        System.out.println(hm.get(null));

        try {
            ht.put(null, "123");    //将会抛出异常
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }

    public static void TestCollections() {
        BaseCollections bc = new BaseCollections();
        //bc.testList();
        //bc.testHashSetAndTreeSet();
        //bc.testMap();
        bc.diffHashMapAndHashTable();
    }
}
