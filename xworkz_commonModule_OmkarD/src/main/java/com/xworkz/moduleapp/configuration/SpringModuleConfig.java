package com.xworkz.moduleapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.moduleapp")
@Import({SecurityConfig.class})
public class SpringModuleConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("com.xworkz.moduleapp.entity");
        bean.setDataSource(getDataSource());
        bean.setJpaProperties(jpaProperties());
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return bean;
    }


    private Properties jpaProperties()
    {
        Properties pro=new Properties();
//        pro.setProperty("hibernate.show_sql","true");
        pro.setProperty("hibernate.hbm2ddl.auto","update");
        return pro;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dm=new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dm.setUrl("jdbc:mysql://localhost:3306/ecommerce");
        dm.setUsername("root");
        dm.setPassword("root");
        return dm;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(1048576);
        return multipartResolver;
    }

    @Bean
    public ViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }
}
