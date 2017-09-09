package com.niit.Backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.Authentication;
import com.niit.Backend.Model.User;
@Repository("userDao")
@EnableTransactionManagement
@Transactional

public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
		public UserDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}
	
		public boolean saveorupdate(User user) {
			Authentication auth=new Authentication();
			auth.setUsername(user.getUemail());
			user.getBilling().setUser(user);
			user.getBilling().setMobile_No(user.getUph());
			user.getBilling().setEmail(user.getUemail());
			sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
			sessionFactory.getCurrentSession().saveOrUpdate(auth);
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
			return true;
		}


		public boolean delete(User user) {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}

		public User get(String uid) {
			String c1="from User where uid='"+uid+"'";
			Query q1=sessionFactory.getCurrentSession().createQuery(c1);
			List<User> list=(List<User>) q1.list();
			if(list==null|| list.isEmpty())
			{
			return null;}
			else {
				return list.get(0);
			}
		}

		@Override
		public List<User> list() {
			List<User> user=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return user;
		}

		@Override
		public User isValid(String umail, String pwd) {
			String c1="from User where uemail='"+umail+"' and upwd='"+pwd+"' ";
			Query q1=sessionFactory.getCurrentSession().createQuery(c1);
			List<User> list=(List<User>) q1.list();
			if(list==null|| list.isEmpty())
			{
			return null;}
			else {
				return list.get(0);
			}
		}

		@Override
		public User getUseremail(String uemail) {
			String c1="from User where uemail='"+uemail+"'";
			Query q1=sessionFactory.getCurrentSession().createQuery(c1);
			List<User> list=(List<User>) q1.list();
			if(list==null|| list.isEmpty())
			{
			return null;}
			else {
				return list.get(0);
			}
}}
