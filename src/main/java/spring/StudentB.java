package main.java.spring;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by liyujiang on 2018/8/15.
 */
public class StudentB {

    Pen pen;

    StudentB() {}

    //用xml 自动填充笔 用Required保证确定
    @Required
    public void setPen(Pen pen) {
        this.pen = pen;
    }

    void write() {
        System.out.println("i'm using " + pen.toString());
    }
}
