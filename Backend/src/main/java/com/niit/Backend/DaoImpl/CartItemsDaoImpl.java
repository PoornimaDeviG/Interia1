package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.CartItemsDao;
import com.niit.Backend.Model.Cart;
import com.niit.Backend.Model.CartItems;

@Repository("cartItemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao {
@Autowired
SessionFactory sessionFactory;
public CartItemsDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
}
@Override
public boolean saveorupdate(CartItems cartit) {
	sessionFactory.getCurrentSession().saveOrUpdate(cartit);
	return true;
}

@Override
public boolean delete(CartItems cartit) {
	sessionFactory.getCurrentSession().delete(cartit);
	return true;
}

@Override
public CartItems get(String cartitemId) {
	String c1="from CartItems where CartItem_Id='"+cartitemId+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<CartItems> list=(List<CartItems>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list.get(0);
	}
}

@Override
public List<CartItems> list() {
	List<CartItems> cartitems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return cartitems;
}
@Override
public CartItems getListall(String Cart_Id, String pid) {
	String c1="from CartItems where Cart_Id='"+Cart_Id+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<CartItems> list=(List<CartItems>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list.get(0);
	}
}
@Override
public List<CartItems> getlist(String Cart_Id) {
	String c1="from CartItems where Cart_Id='"+Cart_Id+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<CartItems> list=(List<CartItems>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list;
	}
}
}
