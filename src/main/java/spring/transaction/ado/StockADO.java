package main.java.spring.transaction.ado;


import main.java.spring.transaction.pojo.Stock;

/**
 * Created by liyujiang on 2018/8/16.
 */
public interface StockADO {
    //增加股票
    boolean addStock(String name, int count) throws Exception;


    Stock getStock(String name) throws Exception;

    //修改股票
    boolean updateStock(String name, int count)throws Exception;
}
