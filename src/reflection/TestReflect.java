package reflection;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Properties;

/**
 * Created by liyujiang on 2018/8/11.
 */

public class TestReflect {

    //获取class信息
    public void getClassInfo() {

        //1.根据实例对象
        StudentA stu = new StudentA();
        Class stuClazz1 = stu.getClass();
        System.out.println(stuClazz1.getName());

        //2.根据类
        Class stuClazz2 = StudentA.class;
        System.out.println(stuClazz1.getName());

        //3.使用Class.forName 这个最常用
        try {
            Class stuClazz3 = Class.forName("reflection.StudentA");
            System.out.println(stuClazz3.getName());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    //获取构造函数
    public void getClassConstructors() throws Exception {

        Class stuClazz = Class.forName("reflection.StudentB");
        Constructor c;
        Object obj;

        //获取所有构造方法
        System.out.println("****************获取所有构造方法***************");
        Constructor[] constructors1 = stuClazz.getDeclaredConstructors();
        for (Constructor c1 : constructors1) {
            System.out.println(c1.toString());

            //调用 私有构造函数
            if (!c1.isAccessible()) {  //这里为什么 public的构造函数也是为false
                c1.setAccessible(true);
                //c1.newInstance("1", "2");
            }
        }


        //获取所有"public"构造方法
        System.out.println("****************获取所有\"public\"构造方法***************");
        constructors1 = stuClazz.getConstructors();
        for (Constructor c1 : constructors1) {
            System.out.println(c1.toString());
        }

        //参数为1个int类型的 构造方法
        System.out.println("****************public 无参数类型的 构造方法***************");
        c = stuClazz.getConstructor(null);
        System.out.println(c.toString());
        c.newInstance(); //初始化1个StudentB对象

        //参数为1个int类型的 构造方法
        System.out.println("****************public 参数为1个int类型的 构造方法***************");
        c = stuClazz.getConstructor(int.class);
        System.out.println(c.toString());

        c.newInstance(1); //初始化1个StudentB对象
    }

    //获取成员定义变量
    public void getClassMembers() {
        Class stuClazz;
        try {
            stuClazz = Class.forName("reflection.StudentC");

            System.out.println("****************名字为\"number1\"的  public 成员变量***************");
            Field field1 = stuClazz.getField("number1");
            System.out.println(field1.toString());

            System.out.println("****************所有的 public 成员变量***************");
            Field[] fields1 = stuClazz.getFields();
            for (Field field : fields1) {
                System.out.println(field.toString());
            }

            System.out.println("****************名字为\"str1\"的成员变量***************");
            Field field2 = stuClazz.getDeclaredField("str1");
            System.out.println(field2.toString());

            System.out.println("****************所有的成员变量***************");
            Field[] fields2 = stuClazz.getDeclaredFields();
            for (Field field : fields2) {
                System.out.println(field.toString());
            }

            System.out.println("****************给str1并且赋值***************");
            Object obj = stuClazz.getConstructor().newInstance(null);
            field2.set(obj, "hello is me");

            StudentC stu = (StudentC) obj;
            System.out.println("stu.str1 is: " + stu.str1);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //获取成员函数
    public void getClassMethod() {
        Class stuClazz;
        try{
            stuClazz = Class.forName("reflection.StudentD");

            System.out.println("****************获取 public 所有方法***************");
            Method[] methods1 = stuClazz.getMethods();
            for (Method method : methods1) {
                System.out.println(method.toString());
            }

            System.out.println("****************获取 public 某个方法***************");
            Method method1 = stuClazz.getMethod("show2", int.class);
            System.out.println(method1.toString());

            System.out.println("****************获取 所有的 方法***************");
            Method[] methods2 = stuClazz.getDeclaredMethods();
            for (Method method : methods1) {
                System.out.println(method.toString());
            }

            System.out.println("****************获取 所有中的 某个方法***************");
            Method method2 = stuClazz.getDeclaredMethod("show4", int.class, String.class);
            System.out.println(method2.toString());

            //使用
            System.out.println("****************使用***************");
            Object obj = stuClazz.getConstructor(null).newInstance();
            method1.invoke(obj, 1); //打印： public void show1() ~~~

            //必须将访问设置为true 这样才不会抛出异常
            method2.setAccessible(true);
            method2.invoke(obj, new Object[]{1, "jiang"});

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //
    public void reflectFromLocal() {
        FileReader fr;
        try {
            /*fr = new FileReader("resources/classreflect.config");
            Properties properties = new Properties();
            properties.load(fr);

            String className = (String)properties.get("classname");
            String methodCall = (String)properties.get("method");

            //String[] methodAndArgs = methodCall.split();

            Class clazz = Class.forName(className);
            Method[] methods = clazz.getDeclaredMethods();
            //for (Method method : )
            method.setAccessible(true);

            Parameter[] parameters = method.getParameters();
            Object[] argvs = new Object[parameters.length];     //生成一个参数数组对象
            for (int i = 0; i < parameters.length; i++) {
                Parameter p = parameters[i];
                Class pClazz = p.getType();
                if(pClazz == int.class) {
                    argvs[i] = 3;
                    System.out.println("class:" + clazz.getName() + " method:" + clazz.getName() + " argv i:" + i + " is :" + 3);
                } else if(pClazz == String.class) {
                    argvs[i] = "nice";
                    System.out.println("class:" + clazz.getName() + " method:" + clazz.getName() + " argv i:" + i + " is : nice");
                }
            }

            Object obj = clazz.getConstructor().newInstance();
            method.invoke(obj, argvs);
*/
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void testReflect() {
        TestReflect t = new TestReflect();
        t.getClassInfo();
        try {

            //t.getClassConstructors();
            //t.getClassMembers();
            //t.getClassMethod();
            t.reflectFromLocal();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
