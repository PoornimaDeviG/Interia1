package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Model.Product;

@Controller
public class HomeController {
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("/")
	public ModelAndView home()
	{
		List<Category> categories= categoryDao.list();
		ModelAndView obj=new ModelAndView("Home");
		obj.addObject("lcat",categories);
		return obj;

	}
	@RequestMapping("/Home")
	public ModelAndView home1()
	{
		List<Category> categories= categoryDao.list();
		ModelAndView obj=new ModelAndView("Home");
		obj.addObject("lcat",categories);
		return obj;
	}

//@REQUESTMAPPING("/LOGIN")
//PUBLIC STRING LOGIN()
//{
//	RETURN "LOGIN";
//}
//@RequestMapping("/category")
//
//public String category()
//{
//	return "Category";
//}
//@RequestMapping("/product")
//public String product()
//{
//	return "Product";
//}
//@RequestMapping("/supplier")
//public String supplier()
//{
//	return "Supplier";
//}
//@RequestMapping("/user")
//		public String user()
//		{
//			return "User";
//		}
	@RequestMapping("/dispcategory/{cid}")
	public ModelAndView dispcategory(@PathVariable("cid")String id)
	{
		List<Category> categories= categoryDao.list();
		ModelAndView obj=new ModelAndView("Furniture");
		List<Product> lc=productDao.getProductByCategory(id);
		obj.addObject("products",lc);
		obj.addObject("cat",new Category());
		obj.addObject("lcat",categories);
		return obj;
	}
	
	@RequestMapping("/Thankyou")
	public ModelAndView Thankyou()
	{
		ModelAndView obj=new ModelAndView("Thankyou");
		List<Category> categories= categoryDao.list();
		obj.addObject("lcat",categories);
		return obj;
	}
	@RequestMapping("/About")
	public ModelAndView About()
	{
		ModelAndView obj=new ModelAndView("About");
		List<Category> categories= categoryDao.list();
		obj.addObject("lcat",categories);
		return obj;
	}
	@RequestMapping("/Contact")
	public ModelAndView Contact()
	{
		ModelAndView obj=new ModelAndView("Contact");
		List<Category> categories= categoryDao.list();
		obj.addObject("lcat",categories);
		return obj;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

