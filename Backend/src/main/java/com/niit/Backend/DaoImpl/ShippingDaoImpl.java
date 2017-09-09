package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.ShippingDao;
import com.niit.Backend.Model.Shipping;

@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImpl implements ShippingDao {
@Autowired
SessionFactory sessionFactory;
public ShippingDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
}

@Override
public boolean saveorupdate(Shipping ship) {
	sessionFactory.getCurrentSession().saveOrUpdate(ship);
	return true;
}

@Override
public boolean delete(Shipping ship) {
	sessionFactory.getCurrentSession().delete(ship);
	return true;
}

@Override
public Shipping get(String shipId) {
	String c1="from Shipping where Shiping_Id='"+shipId+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<Shipping> list=(List<Shipping>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list.get(0);
	}
}

@Override
public List<Shipping> list() {
	List<Shipping> ship=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return ship;

}

@Override
public List<Shipping> getaddbyUser(String uid) {
	String c1="from Shipping where uid='"+uid+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	List<Shipping> list=(List<Shipping>) q1.list();
	if(list==null|| list.isEmpty())
	{
	return null;}
	else {
		return list;
	}
}

}
