package main.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by liyujiang on 2018/8/12.
 */


public class TestSpring {

    ClassPathXmlApplicationContext context1;

    //加载spring配置
    void initSpringConfig() {

        //第一种使用ClassPathXmlApplicationContext  从同类包根路径目录搜索（这里是放到src下面）
        context1 = new ClassPathXmlApplicationContext("main/java/resources/beans.xml");
        Student student = (Student) context1.getBean("student_1");
        System.out.println(student.toString());

        //第二种使用FileSystemXmlApplicationContext 从工程根目录搜索（放在JavaDemo里面）
        ApplicationContext context3 = new FileSystemXmlApplicationContext("src/main/java/resources/beans.xml");
        student = (Student) context3.getBean("student_1");
        //System.out.println(student.toString());

        //第三种使用FileSystemXmlApplicationContext  但是使用绝对路径
        String path = System.getProperty("user.dir");
        ApplicationContext context4 = new FileSystemXmlApplicationContext(path + "/src/main/java/resources/beans.xml");
        student = (Student) context3.getBean("student_1");
       // System.out.println(student.toString());
    }

    //测试生命周期
    void testBeanLife() {
        Student student = (Student) context1.getBean("student_1");
        //关闭这个SpringIoc的容器，就会调用bean的destroy
        context1.registerShutdownHook();
    }

    //测试继承
    void testBeanInherit() {
        Student student = (Student) context1.getBean("student_2");
        student.printHumanInfo();
    }

    //测试自动装配
    void testAutowired() {
        //byType
        StudentB student1 = (StudentB) context1.getBean("studentB_1");
        student1.write();

        //byName
        StudentB student2 = (StudentB) context1.getBean("studentB_2");
        student2.write();
    }

    //测试注解注入
    void testAnnotationWired() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/java/resources/annotationbeans.xml");
        StudentC studentC = (StudentC) context.getBean("studentC_1");
        studentC.write();
        System.out.println(studentC.getBackupClothes().toString());
    }


    public static void testSpring() {
        TestSpring t = new TestSpring();
        //t.initSpringConfig();
        //t.testBeanLife();
        //t.testBeanInherit();
        //t.testAutowired();
        t.testAnnotationWired();
        //t.testAnnotationWired();
    }
}
