package main.java.spring.transaction.pojo;

/**
 * Created by Administrator on 2018/8/16.
 */
public class Stock {
    private int stockid;
    private String name;
    private Integer count;

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
