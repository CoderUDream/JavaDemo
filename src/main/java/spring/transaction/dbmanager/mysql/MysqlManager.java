package main.java.spring.transaction.dbmanager.mysql;

import main.java.spring.transaction.beanManager.BeanMananger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class MysqlManager {

    private static JdbcTemplate mysqlManager;

    private MysqlManager(){}

    public synchronized static JdbcTemplate getInstance() {

        mysqlManager = (JdbcTemplate)BeanMananger.getInstance().getBean("jdbcTemplate");
         return mysqlManager;
    }
}
