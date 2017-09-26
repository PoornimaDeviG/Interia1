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
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;

@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired 
	CategoryDao categoryDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@RequestMapping("/category")
	public ModelAndView  category() {
		ModelAndView obj=new ModelAndView("Category");
		obj.addObject("category",new Category());
		List<Category> lc=categoryDao.list();
		obj.addObject("categories",lc);
		obj.addObject("lcat",lc);
		return obj;	
	}
	@RequestMapping("/addcat")
	public ModelAndView addcat(@ModelAttribute("category")Category category) {
		ModelAndView obj=new ModelAndView("redirect:/category");
		if(categoryDao.saveorupdate(category)==true) {
		
			obj.addObject("msg1","Category added successfully");
		}
		else {
			obj.addObject("msg2","Category not added");
		}
		return obj;
	}
	
	@RequestMapping("/editCategory/{cid}")
	public ModelAndView editcat(@PathVariable("cid")String id){
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("Category");
		category=categoryDao.get(id);
		obj.addObject("category",category);
		obj.addObject("categories", categories);
		return obj;
	}
	@RequestMapping("/deleteCategory/{cid}")
	public ModelAndView delete(@PathVariable("cid") String id) {
	 ModelAndView obj=new ModelAndView("redirect:/category");
		List<Product> lp =productDao.getProductByCategory(id);
		if(lp==null||lp.isEmpty()) {
			categoryDao.delete(category);
			obj.addObject("msg1","category deleted successfully");
		}
		else {
			for(Product p: lp) {
				productDao.delete(p);
			}
			categoryDao.delete(category);
			obj.addObject("msg","category and list of products deleted");
		}
		return obj;
	}
}

