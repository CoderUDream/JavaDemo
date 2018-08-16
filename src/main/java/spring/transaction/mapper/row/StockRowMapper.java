package main.java.spring.transaction.mapper.row;

import main.java.spring.transaction.pojo.Stock;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by liyujiang on 2018/8/16.
 */
public class StockRowMapper implements RowMapper<Stock> {

    @Override
    public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
        //获取结果集中的数据
        int stockid = resultSet.getInt("stockid");
        String name = resultSet.getString("name");
        int count = resultSet.getInt("count");

        //把数据封装成Stock对象
        Stock stock = new Stock();
        stock.setStockid(stockid);
        stock.setName(name);
        stock.setCount(count);
        return stock;
    }
}
