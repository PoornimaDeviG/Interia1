package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Dao.SupplierDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;
import com.niit.Backend.Model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("/supplier")
	public ModelAndView Supplier() {
	ModelAndView obj=new ModelAndView("Supplier");
	obj.addObject("supplier",new Supplier());
	List<Supplier> li=supplierDao.list();
	obj.addObject("suppliers",li);
	List<Category> categories= categoryDao.list();
	obj.addObject("lcat",categories);
	return obj;	
}
	@RequestMapping("/addsup")
	public ModelAndView addsup(@ModelAttribute("supplier")Supplier supplier) {
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		List<Category> categories= categoryDao.list();
		obj.addObject("lcat",categories);
		if(supplierDao.saveorupdate(supplier)==true) {
		
			obj.addObject("msg1","supplier added successfully");
		}
		else {
			obj.addObject("msg2","supplier not added");
		}
		return obj;
	}
	@RequestMapping("/editsupplier/{sid}")
	public ModelAndView editsup(@PathVariable("sid")String id){
		List<Supplier> suppliers=supplierDao.list();
		ModelAndView obj=new ModelAndView("Supplier");
		supplier=supplierDao.get(id);
		obj.addObject("supplier",supplier);
		obj.addObject("suppliers", suppliers);
		return obj;
	}
	@RequestMapping("/deletesupplier/{sid}")
	public ModelAndView delete(@PathVariable("sid") String id) {
	 ModelAndView obj=new ModelAndView("redirect:/supplier");
		List<Product> lp =productDao.getProductByCategory(id);
		if(lp==null||lp.isEmpty()) {
			supplierDao.delete(supplier);
			obj.addObject("msg1","supplier deleted successfully");
		}
		else {
			for(Product p: lp) {
				productDao.delete(p);
			}
			supplierDao.delete(supplier);
			obj.addObject("msg","supplier and list of products deleted");
		}
		return obj;
	}
	
}
