package com.qg.taxi.other.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by logan on 2017/7/31.
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@PropertySource(ignoreResourceNotFound = true, value = "classpath:other.properties")
@MapperScan(basePackages = OracleDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleDataSourceConfig {

    // 精确到 oracle 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.qg.taxi.dao.oracle";
    static final String MAPPER_LOCATION = "classpath:mapper/oracle/*.xml";

    @Value("${spring.datasource.oracle.url}")
    private String url;

    @Value("${spring.datasource.oracle.username}")
    private String user;

    @Value("${spring.datasource.oracle.password}")
    private String password;

    @Value("${spring.datasource.oracle.driverClassName}")
    private String driverClass;

    @Bean(name = "oracleDataSource")
    public DataSource oracleDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager oracleTransactionManager() {
        return new DataSourceTransactionManager(oracleDataSource());
    }

    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oracleDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(OracleDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
