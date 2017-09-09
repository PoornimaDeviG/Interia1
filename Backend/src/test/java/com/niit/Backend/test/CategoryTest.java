package com.niit.Backend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Model.Category;
public class CategoryTest {
public static void main(String args[]) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();	
	Category category=(Category)ctx.getBean("category");
	CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
	category.setCid("c105");
	category.setCname("category5");
	if(categoryDao.saveorupdate(category)==true) {
		System.out.println("category is saved succesfully");
	}
	else {
		System.out.println("category is not saved");
	}
//	category=categoryDao.get("c103");
//	if(categoryDao.delete(category)==true)
//	{
//		System.out.println("Category deleted");
//	}
//	else {
//		System.out.println("Category not deleted");
//	}
	
	category=categoryDao.get("c102");
	if(category==null) {
		System.out.println("category not found");}
	else
	{
		System.out.println(category.getCid());
		System.out.println(category.getCname());
	}
	
	List<Category> cat=categoryDao.list();
	for(Category c:cat)
	{
		System.out.println(c.getCid());
		System.out.println(c.getCname());
	}
}
}
