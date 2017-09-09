package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.OrderItemsDao;
import com.niit.Backend.Model.OrderItems;

public class OrderItemsTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		OrderItems orderitems=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao orderitemsDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
		orderitems.setOrderitem_Id("oi101");
		orderitems.setProduct_Id("5489");

		if(orderitemsDao.saveorupdate(orderitems)==true) {
			System.out.println("orderitems is saved succesfully");
		}
		else {
			System.out.println("ordeitemsr is not saved");
		}
		/*orderitems=orderItemsDao.get("oi101");
		if(orderDao.delete(order)==true)
		{
			System.out.println("orderitems deleted");
		}
		else {
			System.out.println("orderitems not deleted");
		}*/
		
		orderitems=orderitemsDao.get("oi101");
		if(orderitems==null) {
			System.out.println("orderitems not found");}
		else
		{
			System.out.println(orderitems.getOrderitem_Id());
			System.out.println(orderitems.getProduct_Id());

			
		}
	}
	}





