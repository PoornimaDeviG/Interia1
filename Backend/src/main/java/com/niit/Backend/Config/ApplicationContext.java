package com.niit.Backend.Config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.Dao.AuthenticationDao;
import com.niit.Backend.Dao.BillingDao;
import com.niit.Backend.Dao.CartDao;
import com.niit.Backend.Dao.CartItemsDao;
import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.OrderDao;
import com.niit.Backend.Dao.OrderItemsDao;
import com.niit.Backend.Dao.PayDao;
import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Dao.ShippingDao;
import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.DaoImpl.AuthenticationDaoImpl;
import com.niit.Backend.DaoImpl.BillingDaoImpl;
import com.niit.Backend.DaoImpl.CartDaoImpl;
import com.niit.Backend.DaoImpl.CartItemsDaoImpl;
import com.niit.Backend.DaoImpl.CategoryDaoImpl;
import com.niit.Backend.DaoImpl.OrderDaoImpl;
import com.niit.Backend.DaoImpl.OrderItemsDaoImpl;
import com.niit.Backend.DaoImpl.PayDaoImpl;
import com.niit.Backend.DaoImpl.ProductDaoImpl;
import com.niit.Backend.DaoImpl.ShippingDaoImpl;
import com.niit.Backend.DaoImpl.SupplierDaoImpl;
import com.niit.Backend.DaoImpl.UserDaoImpl;
import com.niit.Backend.Model.Authentication;
import com.niit.Backend.Model.Billing;
import com.niit.Backend.Model.Cart;
import com.niit.Backend.Model.CartItems;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Order;
import com.niit.Backend.Model.OrderItems;
import com.niit.Backend.Model.Pay;
import com.niit.Backend.Model.Product;
import com.niit.Backend.Model.Shipping;
import com.niit.Backend.Model.Supplier;
import com.niit.Backend.Model.User;


@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/Interia");
		dataSource.setUsername("poornima");
		dataSource.setPassword("poornima");
		return dataSource;
}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}
@Autowired
@Bean("billingDao")
public BillingDao getBillingDao(SessionFactory sessionFactory) {
	return new BillingDaoImpl(sessionFactory);
}
@Autowired
@Bean("cartDao")
public CartDao getCartDao(SessionFactory sessionFactory) {
	return new CartDaoImpl(sessionFactory);
}
@Autowired
@Bean("cartItemsDao")
public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
	return new CartItemsDaoImpl(sessionFactory);
}
@Autowired
@Bean("orderDao")
public OrderDao getOrderDao(SessionFactory sessionFactory) {
	return new OrderDaoImpl(sessionFactory);
}
@Autowired
@Bean("orderItemsDao")
public OrderItemsDao getOrderItemsDao (SessionFactory sessionFactory) {
	return new OrderItemsDaoImpl(sessionFactory);
}
@Autowired
@Bean("payDao")
public PayDao getPayDao(SessionFactory sessionFactory) {
	return new PayDaoImpl(sessionFactory);
}
@Autowired
@Bean("shippingDao")
public ShippingDao getShippingDao (SessionFactory sessionFactory) {
	return new ShippingDaoImpl(sessionFactory);
}
@Autowired
@Bean("authenticationDao")
public AuthenticationDao getAuthenticationDao (SessionFactory sessionFactory) {
	return new AuthenticationDaoImpl(sessionFactory);
}
}