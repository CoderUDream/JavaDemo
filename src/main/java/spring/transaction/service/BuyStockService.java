package main.java.spring.transaction.service;

/**
 * Created by Administrator on 2018/8/16.
 */
public interface BuyStockService {

    boolean addAccount(String name, int money);

    boolean addStock(String name, int count);

    boolean buyStock(String accountName, String stockName, int count);
}
