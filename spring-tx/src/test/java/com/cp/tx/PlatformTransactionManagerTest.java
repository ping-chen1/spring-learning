package com.cp.tx;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.parsing.DefaultsDefinition;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.SQLException;

public class PlatformTransactionManagerTest {

    private DruidDataSource dataSource;

    @Before
    public void init() throws SQLException {
        dataSource = new DruidDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://192.168.44.163:3306/test?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("vmuser");
        dataSource.setPassword("cp@1234567890");
    }

    @Test
    public void commitTest(){
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES ('事务2', '52', '1234567789@qq.com', '上海市宝山区', '13100000000', now(), now(), '5555555', '0')");
            transactionManager.commit(transactionStatus);
        }catch (Exception e){
            transactionManager.rollback(transactionStatus);
        }
    }

    /**
     * 没有采用事务 update更新成功
     */
    @Test
    public void rollbackNoTransactionTest(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("update t_user set name = '事务回滚jdbc1' where id = 148");
        jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES ('事务2', '52', '1234567789@qq.com', '上海市宝山区', '13100000000', now(), now(), '55555555555555555555555555555555555', '0')");
    }

    @Test
    public void rollbackTransactionTest(){
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("update t_user set name = '事务回滚jdbc2' where id = 148");
            jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES ('事务2', '52', '1234567789@qq.com', '上海市宝山区', '13100000000', now(), now(), '55555555555555555555555555555555555', '0')");
            transactionManager.commit(transactionStatus);
        }catch (Exception e){
            transactionManager.rollback(transactionStatus);
        }
    }

    public void commit(){

    }
}
