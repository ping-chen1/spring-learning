package service;

import anno.JdbcColum;
import com.alibaba.druid.pool.DruidDataSource;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class JdbcTest {

    private DruidDataSource dataSource;

    @Before
    public void init() {
        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://toms-mycat-sit.cloud.bz:28066/toms_st?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
        dataSource.setUsername("toms_st");
        dataSource.setPassword("toms_st");
    }


    @Test
    public void pfsTest(){

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
    public void insertPreparedStatementCreator返回id(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "insert返回id");
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
        }, generatedKeyHolder);
        System.out.println(generatedKeyHolder.getKey() + ", " + update);
    }

    @Test
    public void inse66t(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int update = jdbcTemplate.update("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                , Arrays.asList("周六", 25, "1546987@qq.com", "河南省焦作市", "13611111111", new Date(), new Date(), "1235987", Boolean.FALSE),
                Arrays.asList(JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.INTEGER.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.DATE.getVendorTypeNumber(), JDBCType.DATE.getVendorTypeNumber(), JDBCType.VARCHAR.getVendorTypeNumber(), JDBCType.BOOLEAN.getVendorTypeNumber()));
        System.out.println(update);
    }

    @Test
    public void batchUpdateSqlTest(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES ('batchUpdateSql', '52', '1234567789@qq.com', '上海市宝山区', '13100000000', now(), now(), '123456', '0')");
        System.out.println(ints);
    }


    @Test
    public void batchUpdateSqlAndArgsTest(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Arrays.asList(new Object[]{"batchUpdateSqlAndArgs1", "52", "1234567789@qq.com", "上海市宝山区", "13100000000", new Date(), new Date(), "123456", "0"},
                        new Object[]{"batchUpdateSqlAndArgs2", "52", "1234567789@qq.com", "上海市宝山区", "13100000000", new Date(), new Date(), "123456", "0"})
        );
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void batchUpdateSqlAndArgs1Test(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, "下冰雹" + i);
                        ps.setInt(2, 26);
                        ps.setString(3, "987654321@qq.com");
                        ps.setString(4, "上海市杨浦区");
                        ps.setString(5, "13422222222");
                        ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
                        ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                        ps.setString(8, "1234568952");
                        ps.setBoolean(9, Boolean.FALSE);
                    }

                    @Override
                    public int getBatchSize() {
                        return 10;
                    }
                }
        );

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void batchUpdateSqlAndArgs1Test2(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, "下冰雹" + i);
                        ps.setInt(2, 26);
                        ps.setString(3, "987654321@qq.com");
                        ps.setString(4, "上海市杨浦区");
                        ps.setString(5, "13422222222");
                        ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
                        ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                        ps.setString(8, "1234568952");
                        ps.setBoolean(9, Boolean.FALSE);
                    }

                    @Override
                    public int getBatchSize() {
                        return 10;
                    }
                }
        );

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void batchUpdateSqlListSizeSetter(){
        List<User> users = buildUsers();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[][] ints = jdbcTemplate.batchUpdate("INSERT INTO t_user (name, age, email, address, telephone, create_time, update_time, password, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                users, users.size(), new ParameterizedPreparedStatementSetter<User>() {
                    @Override
                    public void setValues(PreparedStatement ps, User user) throws SQLException {
                        ps.setObject(1, user.getName());
                        ps.setObject(2, user.getAge());
                        ps.setObject(3, user.getEmail());
                        ps.setObject(4, user.getAddress());
                        ps.setObject(5, user.getTelephone());
                        ps.setObject(6, user.getCreateTime());
                        ps.setObject(7, user.getUpdateTime());
                        ps.setObject(8, user.getPassword());
                        ps.setObject(9, user.getDelete());
                    }
                });
        System.out.println(ints.toString());
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void query无参ResultSetExtractor(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User user = jdbcTemplate.query("select * from t_user limit 1", new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    Class<? extends User> aClass = User.class;
                    Field[] declaredFields = aClass.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        JdbcColum annotation = declaredField.getAnnotation(JdbcColum.class);
                        if (null != annotation ){
                            try {
                                Class<?> type = declaredField.getType();
                                declaredField.setAccessible(Boolean.TRUE);
                                if (Boolean.TYPE == type ||  Boolean.class == type){
                                    boolean aBoolean = resultSet.getBoolean(annotation.value());
                                    declaredField.set(user,aBoolean);
                                }else {
                                    Object object = resultSet.getObject(annotation.value());
                                    declaredField.set(user, type.cast(object));
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    users.add(user);
                }
                return users.get(0);
            }
        });
        System.out.println(user);
    }

    @Test
    public void query无参PreparedStatementCreatorAndPreparedStatementSetterAndResultSetExtractor(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory("select * from t_user limit 1");
        User query = jdbcTemplate.query(creatorFactory.newPreparedStatementCreator((List<?>) null), creatorFactory.newPreparedStatementSetter((List<?>) null), new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<User> users = new ArrayList<>();
                while (rs.next()) {
                    User user = new User();
                    Class<User> userClass = User.class;
                    Field[] declaredFields = userClass.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        JdbcColum annotation = declaredField.getAnnotation(JdbcColum.class);
                        if (null != annotation) {
                            try {
                                Class<?> type = declaredField.getType();
                                String value = annotation.value();
                                declaredField.setAccessible(Boolean.TRUE);
                                if (type == Boolean.TYPE || type == Boolean.class) {
                                    boolean aBoolean = rs.getBoolean(value);
                                    declaredField.set(user, aBoolean);
                                } else {
                                    Object object = rs.getObject(value);
                                    declaredField.set(user, type.cast(object));
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    users.add(user);
                }
                return users.get(0);
            }
        });
        System.out.println(query);
    }

    /**
     * BeanPropertyRowMapper 返回bean数据的list集合
     */
    @Test
    public void queryBeanPropertyRowMapper(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List list = jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }

    /**
     * SingleColumnRowMapper 返回单列数据的list
     */
    @Test
    public void querySingleColumnRowMapper(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> name = jdbcTemplate.query("select name from t_user", new SingleColumnRowMapper<>(String.class));
        System.out.println(name);
    }

    /**
     * 使用的是SingleColumnRowMapper 所以返回的是单个的字段
     */
    @Test
    public void queryForObjectForClass(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String s = jdbcTemplate.queryForObject("select name from t_user limit 1", String.class);
        System.out.println(s);
    }

    /**
     * 使用的是SingleColumnRowMapper 返回单个字段的list
     */
    @Test
    public void queryForListForClass(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> strings = jdbcTemplate.queryForList("select name from t_user", String.class);
        System.out.println(strings);
    }

    public void query(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //jdbcTemplate.queryForObject("select * from t_user", new long[]{100L},new BeanPropertyRowMapper<>(User.class))
    }

    private List<User> buildUsers(){
        User user = new User();
        user.setName("batchUpdate3");
        user.setAge(20);
        user.setAddress("aaaa");
        user.setEmail("789521@qq.com");
        user.setTelephone("13611111211");
        user.setDelete(Boolean.FALSE);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User user1 = new User();
        user1.setName("batchUpdate4");
        user1.setAge(20);
        user1.setAddress("aaaa");
        user1.setEmail("789521@qq.com");
        user1.setTelephone("13611111211");
        user1.setDelete(Boolean.FALSE);
        user1.setCreateTime(new Date());
        user1.setUpdateTime(new Date());
       return Arrays.asList(user,user1);
    }

    @Test
    public void test(){

    }
}
