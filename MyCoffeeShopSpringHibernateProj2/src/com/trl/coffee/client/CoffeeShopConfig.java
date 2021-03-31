package com.trl.coffee.client;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.bean.Bill;
import com.trl.coffee.bean.Coffee;
import com.trl.coffee.bean.Customer;
import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.bean.Orders;
import com.trl.coffee.bean.Voucher;
import com.trl.coffee.dao.AddOnDaoImpl;
import com.trl.coffee.dao.BillDaoImpl;
import com.trl.coffee.dao.CoffeeDaoImpl;
import com.trl.coffee.dao.CustomerDaoImpl;
import com.trl.coffee.dao.OrderDaoImpl;
import com.trl.coffee.dao.OrderDetailsDaoImpl;
import com.trl.coffee.dao.VoucherDaoImpl;
import com.trl.coffee.presentation.AddOnPresentationImpl;
import com.trl.coffee.presentation.BillPresentationImpl;
import com.trl.coffee.presentation.CoffeePresentationImpl;
import com.trl.coffee.presentation.CustomerPresentationImpl;
import com.trl.coffee.presentation.OrderDetailsPresentationImpl;
import com.trl.coffee.presentation.OrderPresentImpl;
import com.trl.coffee.service.AddOnServiceImpl;
import com.trl.coffee.service.BillServiceImpl;
import com.trl.coffee.service.CoffeeServiceImpl;
import com.trl.coffee.service.CustomerServiceImpl;
import com.trl.coffee.service.OrderDetailsServiceImpl;
import com.trl.coffee.service.OrderServiceImpl;
import com.trl.coffee.service.VoucherServiceImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.trl.coffee")

public class CoffeeShopConfig {

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
		sessionFactoryBean.setPackagesToScan("com.trl.coffee.bean");
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


	

}
