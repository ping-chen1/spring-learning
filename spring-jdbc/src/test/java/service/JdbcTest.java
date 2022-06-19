package service;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;


public class JdbcTest {

    private DruidDataSource dataSource;

    @Before
    public void init() {
        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.44.163:3306/test?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("vmuser");
        dataSource.setPassword("cp@1234567890");
    }

    @Test
    public void insertNotArgs() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int update = jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES ('张三', '52', '1234567789@qq.com', '上海市宝山区', '13100000000', now(), now(), '123456', '0')");
        System.out.println(update);
    }

    @Test
    public void insertArgs1() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int update = jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                "下雨", 20, "123456789@qq.com", "上海市静安区", "13200000000", new Date(), new Date(), "123789456", Boolean.FALSE);
        System.out.println(update);
    }

    @Test
    public void insertPreparedStatementSetter() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int update = jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "下雪");
                ps.setInt(2, 26);
                ps.setString(3, "987654321@qq.com");
                ps.setString(4, "上海市杨浦区");
                ps.setString(5, "13422222222");
                ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
                ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                ps.setString(8, "1234568952");
                ps.setBoolean(9, Boolean.FALSE);
            }
        });
        System.out.println(update);
    }

    @Test
    public void insertPreparedStatementCreator() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, "下冰雹");
                ps.setInt(2, 26);
                ps.setString(3, "987654321@qq.com");
                ps.setString(4, "上海市杨浦区");
                ps.setString(5, "13422222222");
                ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
                ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                ps.setString(8, "1234568952");
                ps.setBoolean(9, Boolean.FALSE);
                return ps;
            }
        });
        System.out.println(update);
    }

    @Test
    public void inse66t(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int update = jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                , Arrays.asList("周六", 25, "1546987@qq.com", "河南省焦作市", "13611111111", new Date(), new Date(), "1235987", Boolean.FALSE),
                Arrays.asList(JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.INTEGER.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.DATE.getVendorTypeNumber(), JDBCType.DATE.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.BOOLEAN.getVendorTypeNumber()));
        System.out.println(update);
    }
}
