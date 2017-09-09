package com.niit.Backend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Model.Supplier;
public class SupplierTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
		supplier.setSid("s103");
		supplier.setSname("supplier3");
		supplier.setSaddress("About supplier3");
		supplier.setSph("9445154");
		
		if(supplierDao.saveorupdate(supplier)==true) {
			System.out.println("supplier is saved succesfully");
		}
		else {
			
			System.out.println("supplier is not saved");
		}
		
		supplier=supplierDao.get("s101");
		if(supplierDao.delete(supplier)==true)
		{
			System.out.println("supplier deleted");
		}
		else {
			System.out.println("supplier not deleted");
		}
		supplier=supplierDao.get("s102");
		if(supplier==null) {
			System.out.println("supplier not found");}
		else
		{
			System.out.println(supplier.getSid());
			System.out.println(supplier.getSname());
			System.out.println(supplier.getSaddress());
			System.out.println(supplier.getSph());
			
		}

	}
	}


