package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Supplier;
@Repository("supplierDao")
@EnableTransactionManagement
@Transactional


public class SupplierDaoImpl implements SupplierDao {
@Autowired
SessionFactory sessionFactory;
public SupplierDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
	
	public boolean saveorupdate(Supplier sup) {
		sessionFactory.getCurrentSession().saveOrUpdate(sup);
		return true;
	}

	public boolean delete(Supplier sup) {
		sessionFactory.getCurrentSession().delete(sup);
		return true;
	}

	public Supplier get(String sid) {
		String c1="from Supplier where sid='"+sid+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Supplier> list=(List<Supplier>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;
	}	
}
