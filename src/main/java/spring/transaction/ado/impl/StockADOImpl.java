package main.java.spring.transaction.ado.impl;

import main.java.spring.transaction.ado.StockADO;
import main.java.spring.transaction.dbmanager.mysql.MysqlManager;
import main.java.spring.transaction.mapper.row.StockRowMapper;
import main.java.spring.transaction.pojo.Stock;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Administrator on 2018/8/16.
 */
public class StockADOImpl extends JdbcDaoSupport implements StockADO {
    @Override
    public boolean addStock(String name, int count) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();
        String sql = "insert stock(name, count) values(?,?);";

        jdbcTemplate.update(sql,name, count);
        System.out.println("addStock name:" + name + " ,count:" + count);

        return true;
    }

    @Override
    public Stock getStock(String name) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();
        String sql = "select * from stock where name=?;";

        Stock stock = jdbcTemplate.queryForObject(sql, new StockRowMapper(), name);
        return stock;
    }

    @Override
    public boolean updateStock(String name, int count) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();
        String sql = "update stock set count=count+? where name=?;";

        jdbcTemplate.update(sql, count, name);
        System.out.println("updateStock name:" + name + " ,count:" + count);

        return true;
    }
}
