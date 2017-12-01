package com.fangjia.fsh.user.conf;

import com.fangjia.fsh.user.FshUserServiceApplication;
import org.cxytiandi.conf.client.annotation.ConfField;
import org.cxytiandi.conf.client.annotation.CxytianDiConf;
import org.cxytiandi.conf.client.core.SmconfUpdateCallBack;
import org.cxytiandi.conf.client.core.rest.Conf;
import org.springframework.cloud.context.refresh.ContextRefresher;

/**
 * 数据库连接池配置
 *
 * @author yinjihuan
 * @create 2017-11-20 18:16
 **/
@CxytianDiConf(system = "fangjia-fsh-user-service", env = true, prefix = "spring.datasource.druid")
public class MysqlDataSourceConf implements SmconfUpdateCallBack {

    @ConfField("连接地址")
    private String url = "jdbc:mysql://192.168.0.132:4306/fangjia_fsh";

    @ConfField("数据库用户名")
    private String username = "sa";

    @ConfField("数据库密码")
    private String password = "G00jia";

    @ConfField("数据库驱动")
    private String driverClassName = "com.mysql.jdbc.Driver";

    @ConfField("初始化连接数")
    private int initialSize = 10;

    @ConfField("最小连接数")
    private int minIdle = 5;

    @ConfField("最大连接数")
    private int maxActive = 50;

    @ConfField("获取连接时最大等待时间，单位毫秒")
    private int maxWait = 60000;

    @ConfField("Destroy线程会检测连接的间隔时间")
    private int timeBetweenEvictionRunsMillis = 60000;

    @ConfField("minEvictableIdleTimeMillis")
    private int minEvictableIdleTimeMillis = 60000;

    @ConfField("检测连接是否有效的sql")
    private String validationQuery = "SELECT 1 FROM DUAL";

    @ConfField("检测连接是否有效")
    private String testWhileIdle = "true";

    @ConfField("申请连接时执行validationQuery检测连接是否有效")
    private String testOnBorrow = "false";

    @ConfField("归还连接时执行validationQuery检测连接是否有效")
    private String testOnReturn = "false";

    @ConfField("定时输出统计日志的世界，毫秒")
    private int timeBetweenLogStatsMillis = 300000;

    @ConfField("是否缓存preparedStatement，也就是PSCache")
    private String poolPreparedStatements = "true";

    @ConfField("Statement缓存大小")
    private int maxPoolPreparedStatementPerConnectionSize = 20;

    @ConfField("filters")
    private String filters = "stat,wall,log4j";

    @ConfField("连接属性")
    private String connectionProperties = "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=1000";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public String getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(String testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(String testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public int getTimeBetweenLogStatsMillis() {
        return timeBetweenLogStatsMillis;
    }

    public void setTimeBetweenLogStatsMillis(int timeBetweenLogStatsMillis) {
        this.timeBetweenLogStatsMillis = timeBetweenLogStatsMillis;
    }

    public String getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(String poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    @Override
    public void reload(Conf conf) {
        try {
            new ContextRefresher(FshUserServiceApplication.context, null).refresh();
        } catch (NullPointerException e) {}
    }
}
