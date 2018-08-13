package main.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by liyujiang on 2018/8/12.
 */


public class TestSpring {

    ApplicationContext context1;

    //加载spring配置
    void initSpringConfig() {

        //第一种使用ClassPathXmlApplicationContext  从同类包根路径目录搜索（这里是放到src下面）
        context1 = new ClassPathXmlApplicationContext("main/java/resources/beans.xml");
        StudentA student = (StudentA) context1.getBean("StudentA");
        System.out.println(student.toString());

        //第二种使用FileSystemXmlApplicationContext 从工程根目录搜索（放在JavaDemo里面）
        ApplicationContext context3 = new FileSystemXmlApplicationContext("src/main/java/resources/beans.xml");
        student = (StudentA) context3.getBean("StudentA");
        System.out.println(student.toString());

        //第三种使用FileSystemXmlApplicationContext  但是使用绝对路径
        String path = System.getProperty("user.dir");
        ApplicationContext context4 = new FileSystemXmlApplicationContext(path + "/src/main/java/resources/beans.xml");
        student = (StudentA) context3.getBean("StudentA");
        System.out.println(student.toString());
    }

    //测试自动注入
    void testAutowired() {
        StudentA student = (StudentA) context1.getBean("StudentA");
        System.out.println(student.printScore());
    }

    public static void testSpring() {
        TestSpring t = new TestSpring();
        t.initSpringConfig();
        t.testAutowired();
    }
}
