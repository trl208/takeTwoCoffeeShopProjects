package com.trl.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = "com.trl")
@EnableWebMvc
@EnableTransactionManagement
public class CoffeeWebConfig implements WebMvcConfigurer{

	
	@Bean
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:xe","system", "wiley123");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return dataSource;
	}
		
	@Bean
	
	public LocalSessionFactoryBean sessionFactoryBean() {

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.trl.model.bean");
		//sessionFactoryBean.setAnnotatedClasses(AddOn.class,Bill.class,Coffee.class,Customer.class,Orders.class,OrderDetail.class,Voucher.class);
		// sessionFactoryBean.setAnnotatedPackages("com.trl.coffee");

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.hbm2dll.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;

	}
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	 * Configure a handler to delegate unhandled requested by forwarding to the
	 * Servlet Containers "default" Servlet
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


}
