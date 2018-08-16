package main.java.spring.transaction.pojo;

/**
 * Created by Administrator on 2018/8/16.
 */
public class Account {
    private int accountid;
    private String name;
    private int money;
    private int stockCount;


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
