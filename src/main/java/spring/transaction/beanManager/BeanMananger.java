package main.java.spring.transaction.beanManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by liyujiang on 2018/8/16.
 */
public class BeanMananger {

    private static ApplicationContext context;
    public synchronized  static ApplicationContext getInstance() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("main/java/resources/transaction.xml");
        }

        return context;
    }
}
