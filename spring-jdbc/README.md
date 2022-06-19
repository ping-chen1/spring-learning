# spring-jdbc
## JdbcTemplate使用步骤
1. 创建数据源DataSource
2. 创建JdbcTemplate，new JdbcTemplate(dataSource)
3. 调用JdbcTemplate的方法操作db，如增删改查
### 增加、删除、修改操作
1.无参

`int update(final String sql)`

2.有参

`int update(String sql, Object... args)`

`int update(String sql, PreparedStatementSetter pss)`


