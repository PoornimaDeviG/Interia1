package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.OrderItemsDao;
import com.niit.Backend.Model.Order;
import com.niit.Backend.Model.OrderItems;

@Repository("orderItemsDao")
@EnableTransactionManagement
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao {
@Autowired
SessionFactory sessionFactory;
public OrderItemsDaoImpl(SessionFactory sessionFactory ) {
	this.sessionFactory=sessionFactory;
}

@Override
public boolean saveorupdate(OrderItems orderit) {
	sessionFactory.getCurrentSession().saveOrUpdate(orderit);
	return true;
}
@Override
public boolean delete(OrderItems orderit) {
	sessionFactory.getCurrentSession().delete(orderit);
	return true;
}

@Override
public OrderItems get(String orderitemId) {
	
	String c1="from OrderItems where Orderitem_Id='"+orderitemId+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<OrderItems> list=(List<OrderItems>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list.get(0);
	}
}

@Override
public List<OrderItems> list() {
	List<OrderItems> orderitems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return orderitems;
			
}
}
