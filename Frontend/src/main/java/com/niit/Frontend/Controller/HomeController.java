package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Model.Product;

@Controller
public class HomeController {
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	@RequestMapping("/")
	public String home()
	{
		return "Home";
	}
	@RequestMapping("/Home")
	public String Home()
	{
		return "Home";
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
	@RequestMapping("/Furniture")
	public ModelAndView Furniture()
	{
		ModelAndView obj=new ModelAndView("Furniture");
		List<Product> lc=productDao.list();
		obj.addObject("products",lc);
		return obj;
	}
	
//	@RequestMapping("/dispcategory/{cid}")
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

