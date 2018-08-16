package main.java.spring;

/**
 * Created by liyujiang on 2018/8/15.
 */
public class Clothes {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
