package com.trl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.trl.model.bean.AddOn;
import com.trl.model.bean.AddOns;
import com.trl.model.bean.Bill;
import com.trl.model.bean.Coffee;
import com.trl.model.bean.Customer;
import com.trl.model.bean.OrderDetail;
import com.trl.model.bean.Orders;
import com.trl.model.bean.Voucher;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
@ComponentScan(basePackages = "com.trl")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:xe",
				"system", "wiley123");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return dataSource;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter getMessageConvertor() {
		return new MappingJackson2HttpMessageConverter();
	}
	
	@Bean
	public RequestMappingHandlerAdapter getMapping() {
		RequestMappingHandlerAdapter rm=new RequestMappingHandlerAdapter();
		rm.getMessageConverters().add(getMessageConvertor());
		return rm;
	}
	
	@Bean(name = "sessionFactoryBean")
	public LocalSessionFactoryBean sessionFactoryBean() {

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.trl.coffee.bean");
		sessionFactoryBean.setAnnotatedClasses(AddOn.class,AddOns.class,Bill.class,Coffee.class,Customer.class,OrderDetail.class,Orders.class,Voucher.class);
		// sessionFactoryBean.setAnnotatedPackages("com.trl.coffee");

		/*
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.AddOn.class);
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.Bill.class);
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.Coffee.class);
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.Customer.class);
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.Orders.class);
		 * sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.OrderDetail.class)
		 * ; sessionFactoryBean.setAnnotatedClasses(com.trl.coffee.bean.Voucher.class);
		 */
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.hbm2dll.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;

	}
	/*
	 * Configure a handler to delegate unhandled requested by forwarding to the
	 * Servlet Containers "default" Servlet
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
