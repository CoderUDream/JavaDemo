package main.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liyujiang on 2018/8/13.
 */
public class Student {
    private int age;
    private String name;
    private String hobby;
    private ArrayList<String> dress;
    private HashMap<String, String> scoresMap;

    //通用属性
    private String organs;
    private String bloodColor;

    //不带参数构造函数
    public Student() {}

    //初始化方法 bean配置
    public void init() {
        System.out.println("Student is init");
    }

    //销毁方法 bean配置
    public void destroy() {
        System.out.println("Student is destroy");
    }

    //带参构造函数
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() { return hobby; }

    //测试注入普通类型
    @Required
    public void setHobby(String hobby) { this.hobby = hobby; }

    //测试注入list
    @Required
    public void setDress(ArrayList<String> arrayList) {
        this.dress = arrayList;
    }

    //测试注入HashMap
    @Required
    public void setScoresMap(HashMap<String, String> scoresMap) {
        this.scoresMap = scoresMap;
    }

    public void setOrgans(String organs) {
        this.organs = organs;
    }

    public void setBloodColor(String bloodColor) {
        this.bloodColor = bloodColor;
    }

    //打印分数
    public void printScore() {
        System.out.println(scoresMap.toString());
    }

    //打印人类的共同信息
    public void printHumanInfo() {
        System.out.println("organs:" + organs + ", bloodColor:" + bloodColor);
    }

    @Override
    public String toString() {
        return "i'm student my name is:" + name + ", age is:" + age + " hobby is:" + hobby + " dress:" + this.dress.toString();
    }

}
