package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;
@Repository("productDao")
@EnableTransactionManagement
@Transactional
public class ProductDaoImpl implements ProductDao {
@Autowired
SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(Product pro) {
		sessionFactory.getCurrentSession().saveOrUpdate(pro);
	
		return true;
	}


	public boolean delete(Product pro) {
		sessionFactory.getCurrentSession().delete(pro);
		return true;
	}

	public Product get(String pid) {
		String c1="from Product where pid='"+pid+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
	}

	public List<Product> getProductByCategory(String cid) {
		String c1="from Product where cid='"+cid+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list;
		}
}

	
	public List<Product> list() {
		List<Product> product=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}

	@Override
	public List<Product> getProductBySupplier(String sid) {
		// TODO Auto-generated method stub
		return null;
	}
}