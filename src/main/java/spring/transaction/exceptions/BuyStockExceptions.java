package main.java.spring.transaction.exceptions;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class BuyStockExceptions extends Exception {
    public BuyStockExceptions() {
        super();
    }

    public BuyStockExceptions(String message) {
        super(message);
    }
}
