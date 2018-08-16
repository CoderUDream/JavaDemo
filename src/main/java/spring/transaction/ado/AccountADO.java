package main.java.spring.transaction.ado;

import main.java.spring.transaction.pojo.Account;

/**
 * Created by liyujiang on 2018/8/16.
 */
public interface AccountADO {
    //增加账户
    boolean addAccount(String name, int money) throws Exception;

    //查询账户
    Account getAccount(String name) throws Exception;

    //修改账户
    boolean updateAccount(String name, int money) throws Exception;
}
