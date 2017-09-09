package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.OrderDao;
import com.niit.Backend.Model.Order;

public class OrderTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		order.setOrder_Id("o101");
		order.setGrand_Total(36.0);

		order.setOrder_Time("5:00 pm");
		
		if(orderDao.saveorupdate(order)==true) {
			System.out.println("order is saved succesfully");
		}
		else {
			System.out.println("order is not saved");
		}
		/*order=orderDao.get("o101");
		if(orderDao.delete(order)==true)
		{
			System.out.println("order deleted");
		}
		else {
			System.out.println("order not deleted");
		}*/
		
		order=orderDao.get("o101");
		if(order==null) {
			System.out.println("order not found");}
		else
		{
			System.out.println(order.getOrder_Id());
			System.out.println(order.getGrand_Total());
			System.out.println(order.getOrder_Date());
			System.out.println(order.getOrder_Time());
			
		}
	}
	}



