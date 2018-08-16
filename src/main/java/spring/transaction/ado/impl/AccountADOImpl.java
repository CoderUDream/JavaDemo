package main.java.spring.transaction.ado.impl;

import main.java.spring.transaction.ado.AccountADO;
import main.java.spring.transaction.dbmanager.mysql.MysqlManager;
import main.java.spring.transaction.mapper.row.AccountRowMapper;
import main.java.spring.transaction.pojo.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class AccountADOImpl extends JdbcDaoSupport implements AccountADO {

    @Override
    public boolean addAccount(String name, int money) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();
        String sql = "insert account(name, money, stockcount) values(?,?,?);";

        //count 为影响的行数
        jdbcTemplate.update(sql, name, money, 0);
        System.out.println("addAccount name:" + name + " ,money:" + money + ", stock:0");

        return true;
    }

    @Override
    public Account getAccount(String name) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();
        String sql = "select * from account where name=?;";

        //新建AccountRowMapper类实现RowMapper接口，重写mapRow方法，指定返回AccountRowMapper对象
        Account account = jdbcTemplate.queryForObject(sql, new AccountRowMapper(), name);
        return account;
    }

    @Override
    public boolean updateAccount(String name, int money) throws Exception {
        JdbcTemplate jdbcTemplate = MysqlManager.getInstance();

        String sql = "update account set money=money+? where name=?;";
        //count 为影响的行数
        jdbcTemplate.update(sql, money, name);

        money = -money;
        sql = "update account set stockcount=stockcount+? where name=?;";
        jdbcTemplate.update(sql, money, name);

        System.out.println("update name:" + name + " ,money:" + money);

        return true;
    }
}
