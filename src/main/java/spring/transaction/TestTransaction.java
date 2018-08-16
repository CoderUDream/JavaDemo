package main.java.spring.transaction;

import main.java.spring.transaction.beanManager.BeanMananger;
import main.java.spring.transaction.dbmanager.mysql.MysqlManager;
import main.java.spring.transaction.service.BuyStockService;
import main.java.spring.transaction.service.serviceimpl.BuyStockServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class TestTransaction {

    public void initConfig() {
    }

    public static void testTransaction() {
        TestTransaction t = new TestTransaction();
        t.initConfig();

        BuyStockService buyStockService = (BuyStockService)BeanMananger.getInstance().getBean("buyStockService_bean");

        //buyStockService.addAccount("jiang", 100);
        //buyStockService.addStock("apple", 1000);

        buyStockService.buyStock("jiang", "apple", 10);
    }
}
