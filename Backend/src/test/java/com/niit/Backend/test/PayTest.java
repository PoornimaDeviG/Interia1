package com.niit.Backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.PayDao;
import com.niit.Backend.Model.Pay;

public class PayTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();	
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao payDao=(PayDao)ctx.getBean("payDao");
		pay.setPay_Id("py101");
		pay.setPay_Method("cash");
		pay.setStatus("processing");
		
		if(payDao.saveorupdate(pay)==true) {
			System.out.println("pay is saved succesfully");
		}
		else {
			System.out.println("pay is not saved");
		}
		/*pay=payDao.get("py101");
		if(payDao.delete(pay)==true)
		{
			System.out.println("pay deleted");
		}
		else {
			System.out.println("pay not deleted");
		}*/
		
		pay=payDao.get("py101");
		if(pay==null) {
			System.out.println("pay not found");}
		else
		{
			System.out.println(pay.getPay_Id());
			System.out.println(pay.getPay_Method());
			System.out.println(pay.getStatus());
			
		}
	}
	



}
