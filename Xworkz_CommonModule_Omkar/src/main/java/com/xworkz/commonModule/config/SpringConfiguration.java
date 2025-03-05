package com.xworkz.commonModule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.commonModule")
public class SpringConfiguration {

//    @Bean
//    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setPackagesToScan("com.xworkz.commonModule.entity");
//        bean.setDataSource(getDataSource());
//        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        bean.setJpaProperties(getJpaProperties());
//        return bean;
//    }
//
//    private Properties getJpaProperties(){
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.show_sql","true");
//        properties.setProperty("hibernate.hbm2ddl.auto","update");
//        return properties;
//    }
//
//    @Bean
//    public DataSource getDataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("root");
//        return driverManagerDataSource;
//    }

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
