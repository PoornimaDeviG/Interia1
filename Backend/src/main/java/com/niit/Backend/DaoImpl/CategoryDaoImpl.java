package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Model.Category;
@Repository("categoryDao")
@EnableTransactionManagement
@Transactional

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorupdate(Category cat) {
		sessionFactory.getCurrentSession().saveOrUpdate(cat);
	
		return true;
	}


	public boolean delete(Category cat) {
		sessionFactory.getCurrentSession().delete(cat);
		return true;
	}

	public Category get(String cid) {
		String c1="from Category where cid='"+cid+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Category> list=(List<Category>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
	}
		public List<Category> list(){
			List<Category> category=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return category;
					
		}
	}


	