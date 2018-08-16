package main.java.spring.transaction.service.serviceimpl;

import main.java.spring.transaction.ado.AccountADO;
import main.java.spring.transaction.ado.StockADO;
import main.java.spring.transaction.dbmanager.mysql.MysqlManager;
import main.java.spring.transaction.pojo.Account;
import main.java.spring.transaction.pojo.Stock;
import main.java.spring.transaction.service.BuyStockService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class BuyStockServiceImpl implements BuyStockService {

    @Autowired
    @Qualifier("account_bean")
    private AccountADO accountADO;

    @Autowired
    @Qualifier("stock_bean")
    private StockADO stockADO;

    @Override
    public  boolean addAccount(String name, int money) {
        try {
            accountADO.addAccount(name, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addStock(String name, int count) {
        try {
            stockADO.addStock(name, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean buyStock(String accountName, String stockName, int count) {

        try {
            //1.查询有没有这个人
            //2.查询是否有这个股票
            //3.查询钱是否足够

            //这里直接进行操作，方便查看异常
            Account account = accountADO.getAccount(accountName);
            if (account.getMoney() - count < 0) {
                System.out.println(account.getName() + " money not enough");
                return false;
            }
            accountADO.updateAccount(accountName, -count);

            Stock stock = stockADO.getStock(stockName);
            if (stock == null) {
                //回滚
                System.out.println(stock.getName() + " not exist");
                return false;
            }
            stockADO.updateStock(stockName, -count);

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

        String s = String.format("%s buy %d stock:%s", accountName, count, stockName);
        System.out.println(s);
        return true;
    }
}
