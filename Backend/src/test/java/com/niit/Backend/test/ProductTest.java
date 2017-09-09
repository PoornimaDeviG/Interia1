package com.niit.Backend.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;
import com.niit.Backend.Model.Supplier;
public class ProductTest {
public static void main(String args[]) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	Product product=(Product)ctx.getBean("product");
	ProductDao productDao=(ProductDao)ctx.getBean("productDao");
	Category category=(Category)ctx.getBean("category");
	CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
	category=categoryDao.get("c101");
	product.setCategory(category);
	Supplier supplier=(Supplier)ctx.getBean("supplier");
	SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
	supplier=supplierDao.get("s102");
	product.setSupplier(supplier);
	product.setPid("p101");
	product.setPname("product1");
	product.setPdiscription("About product1");
	product.setPprice(5000);
	product.setPquantity(8);
	if(productDao.saveorupdate(product)==true) {
		System.out.println("product is saved succesfully");
	}
	else {
		
		System.out.println("product is not saved");
	}
	product=productDao.get("p102");
	if(productDao.delete(product)==true)
	{
		System.out.println("product deleted");
	}
	else {
		System.out.println("product not deleted");
	}
	
	product=productDao.get("p103");
	if(product==null) {
		System.out.println("product not found");}
	else
	{
		System.out.println(product.getPid());
		System.out.println(product.getPname());
		System.out.println(product.getPdiscription());
		System.out.println(product.getPprice());
		System.out.println(product.getPquantity());
	}

}
}
