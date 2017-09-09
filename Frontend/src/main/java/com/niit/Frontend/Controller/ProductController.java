package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;
import com.niit.Backend.Model.Supplier;
import com.niit.Frontend.Fileinput.Fileinput;

@Controller
public class ProductController {
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired 
Category category;
@Autowired
CategoryDao categoryDao;
@Autowired
Supplier supplier;
@Autowired
SupplierDao supplierDao;
String path="C:\\Users\\poornima girisha\\eclipse-workspace\\Frontend\\src\\main\\webapp\\resources\\Images\\";
@RequestMapping("/product")
public ModelAndView product() {
	ModelAndView obj=new ModelAndView("Product");
	obj.addObject("product",new Product());
	List<Product> lc=productDao.list();
	List<Category> li=categoryDao.list();
	List<Supplier> ls=supplierDao.list();
	obj.addObject("categories",li);
	obj.addObject("products",lc);
	obj.addObject("suppliers",ls);
	return obj;	
	
}
@RequestMapping("/addpro")
public ModelAndView addpro(@ModelAttribute("product")Product pro) {
	ModelAndView obj=new ModelAndView("redirect:/product");
	if(productDao.saveorupdate(pro)==true) {
		Fileinput.upload(path, pro.getPimg(),pro.getPid()+".jpg");
	
		obj.addObject("msg1","Product added successfully");
	}
	else {
		obj.addObject("msg2","Product not added");
	}
	return obj;
}

@RequestMapping("/editProduct/{pid}")
public ModelAndView edit(@PathVariable("pid") String id){
	ModelAndView obj=new ModelAndView("Product");
	product=productDao.get(id);
			obj.addObject("product",product);
			List<Category> li=categoryDao.list();
			obj.addObject("categories",li);
			List<Supplier> ls=supplierDao.list();
			obj.addObject("suppliers",ls);
	List<Product> products=productDao.list();
	obj.addObject("products", products);
	return obj;
}
@RequestMapping("/deleteProduct/{pid}")
public ModelAndView delete(@PathVariable("pid") String id) {
	product=productDao.get(id);
 ModelAndView obj=new ModelAndView("redirect:/product");
 productDao.delete(product);
		obj.addObject("msg1","product deleted successfully");
	return obj;
}}

