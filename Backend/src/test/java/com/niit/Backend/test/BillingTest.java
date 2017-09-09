package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.BillingDao;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.Billing;
import com.niit.Backend.Model.User;
public class BillingTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user=userDao.get("u102");
		bill.setUser(user);
		bill.setBill_Id("b104");
		bill.setHouse_No("35");
		bill.setCountry("India");
		bill.setCity("bangalore");
		bill.setPinCode("560056");
		bill.setEmail("p@gmail.com");
		bill.setMobile_No("975151625");
		
		if(billDao.saveorupdate(bill)==true) {
			System.out.println("Bill is saved succesfully");
		}
		else {
			System.out.println("bill is not saved");
		}
		/*bill=billDao.get("b101");
		if(billDao.delete(bill)==true)
		{
			System.out.println("Bill deleted");
		}
		else {
			System.out.println("Bill not deleted");
		}*/
		
		bill=billDao.get("b102");
		if(bill==null) {
			System.out.println("bill not found");}
		else
		{
			System.out.println(bill.getBill_Id());
			System.out.println(bill.getHouse_No());
			System.out.println(bill.getCountry());
			System.out.println(bill.getCity());
			System.out.println(bill.getPinCode());
			System.out.println(bill.getEmail());
			System.out.println(bill.getMobile_No());
		}
	}
	}

		

