package main.java.spring.transaction.mapper.row;

import main.java.spring.transaction.pojo.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        //获取结果集中的数据
        int accountid = resultSet.getInt("accountid");
        String name = resultSet.getString("name");
        int money = resultSet.getInt("money");
        int stockCount = resultSet.getInt("stockcount");

        //把数据封装成Stock对象
        Account account = new Account();
        account.setAccountid(accountid);
        account.setName(name);
        account.setMoney(money);
        account.setStockCount(stockCount);

        return account;
    }

}
