package com.zmg.hello.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class main {
    public static void main(String args[]) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println("看看啦"+dataSource.getConnection());
    }
}
