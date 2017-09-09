package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.CartDao;
import com.niit.Backend.Dao.CartItemsDao;
import com.niit.Backend.Model.Cart;
import com.niit.Backend.Model.CartItems;

public class CartItemsTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		CartItems cartit=(CartItems)ctx.getBean("cartItems");
		CartItemsDao cartitDao=(CartItemsDao)ctx.getBean("cartItemsDao");
		cartit.setCartitem_Id("cai101");
		cartit.setPrice(56);
		
		if(cartitDao.saveorupdate(cartit)==true) {
			System.out.println("cartitem is saved succesfully");
		}
		else {
			System.out.println("cartitem is not saved");
		}
	cartit=cartitDao.get("cai101");
		/*if(cartitDao.delete(cartit)==true)
		{
			System.out.println("cart item deleted");
		}
		else {
			System.out.println("cart item not deleted");
		}*/
		
		cartit=cartitDao.get("cai101");
		if(cartit==null) {
			System.out.println("cartitem not found");}
		else
		{
			System.out.println(cartit.getCartitem_Id());
			System.out.println(cartit.getPrice());
			
			
		}
	}
	}

