package main.java.spring;

/**
 * Created by Administrator on 2018/8/15.
 */
public class Pen {

    String color;
    int length;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "pen color:" + color + ", length:" + length;
    }
}
