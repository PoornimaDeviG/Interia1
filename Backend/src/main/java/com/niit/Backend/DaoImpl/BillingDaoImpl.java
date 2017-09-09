package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.BillingDao;
import com.niit.Backend.Model.Billing;


@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Billing bil) {
		sessionFactory.getCurrentSession().saveOrUpdate(bil);
		return true;
	}


	public boolean delete(Billing bil) {
		sessionFactory.getCurrentSession().delete(bil);
		return true;
	}


	public Billing get(String uId) {
		String c1="from Billing where uid='"+uId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Billing> list=(List<Billing>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
	
	}

	public List<Billing> list() {
		List<Billing> billing=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billing;
				
	}

}
