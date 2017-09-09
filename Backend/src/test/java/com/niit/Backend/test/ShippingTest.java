package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.ShippingDao;
import com.niit.Backend.Model.Shipping;

public class ShippingTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		ship.setShiping_Id("sh103");
		ship.setHouse_No("35");
		ship.setCountry("India");
		ship.setCity("bangalore");
		ship.setPinCode("560056");
		ship.setEmail("p@gmail.com");
		ship.setMobile_No("975151625");
		ship.setFirst_Name("poornima");
		ship.setLast_Name("Girisha");
		if(shipDao.saveorupdate(ship)==true) {
			System.out.println("ship is saved succesfully");
		}
		else {
			System.out.println("ship is not saved");
		}
		/*ship=shipDao.get("sh101");
		if(shipDao.delete(ship)==true)
		{
			System.out.println("ship deleted");
		}
		else {
			System.out.println("ship not deleted");
		}*/
		
		ship=shipDao.get("sh101");
		if(ship==null) {
			System.out.println("ship not found");}
		else
		{
			System.out.println(ship.getShiping_Id());
			System.out.println(ship.getHouse_No());
			System.out.println(ship.getCountry());
			System.out.println(ship.getCity());
			System.out.println(ship.getPinCode());
			System.out.println(ship.getEmail());
			System.out.println(ship.getMobile_No());
			System.out.println(ship.getFirst_Name());
			System.out.println(ship.getLast_Name());
		}
	}
	}


