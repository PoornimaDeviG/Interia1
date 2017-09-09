package com.niit.Backend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.User;
public class UserTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user.setUid("u102");
		user.setUname("user2");
		user.setUaddress("About use21");
		user.setUph("9456547");
		user.setUemail("poornima@gmail.com");
		user.setUpwd("hima");
		if(userDao.saveorupdate(user)==true) {
			System.out.println("user is saved succesfully");
		}
		else {
			
			System.out.println("user is not saved");
		}
		
		
		user=userDao.get("u102");
		if(user==null) {
			System.out.println("product not found");}
		else
		{
			System.out.println(user.getUid());
			System.out.println(user.getUname());
			System.out.println(user.getUaddress());
			System.out.println(user.getUph());
			System.out.println(user.getUemail());
			System.out.println(user.getUpwd());	
		}
	}
	}


