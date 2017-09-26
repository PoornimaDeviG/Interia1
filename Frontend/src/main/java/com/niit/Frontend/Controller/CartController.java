package com.niit.Frontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.CartDao;
import com.niit.Backend.Dao.CartItemsDao;
import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.ProductDao;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.Cart;
import com.niit.Backend.Model.CartItems;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;
import com.niit.Backend.Model.User;

@Controller
public class CartController
{
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
User user;
@Autowired
UserDao userDao;
@Autowired
Cart cart;
@Autowired
CartDao cartDao;
@Autowired
CartItems cartItems;
@Autowired
CartItemsDao cartItemDao;
@Autowired
HttpSession session;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

@RequestMapping("/addtocart/{pid}")
public ModelAndView cart(@PathVariable("pid") String id)
{
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
		if(user==null)
		{
			return new ModelAndView("redirect:/");
		
		}
		else
		{
		cart=u.getCart();
		Product product1= productDao.get(id);
		CartItems cartItem =new CartItems();
		cartItem.setCart(cart);
		cartItem.setProduct(product1);
		cartItem.setPrice(product1.getPprice());
		cartItemDao.saveorupdate(cartItem);
		cart.setGrand_Total(cart.getGrand_Total()+ product1.getPprice());
		cart.setTotal_Items(cart.getTotal_Items()+1);
		cartDao.saveorupdate(cart);
		session.setAttribute("items", cart.getTotal_Items());
		session.setAttribute("gd", cart.getGrand_Total());
		return new ModelAndView("redirect:/");
		
		}
}
	
	else
	{
		return new ModelAndView("redirect:/");
	}
}
@RequestMapping(value="/viewcart")
public String viewcart(Model model,HttpSession session)
{
	
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
		Cart c= u.getCart();
		List<CartItems> cartItems=cartItemDao.getlist(u.getCart().getCart_Id());
		if(cartItems ==null)
		{
			session.setAttribute("items", 0);
			model.addAttribute("gtotal", 0.0);
			model.addAttribute("msg","no Items is added to cart");
			return "Home";
			
		}
		model.addAttribute("cartItem",cartItems);
		model.addAttribute("gtotal",c.getGrand_Total());
		session.setAttribute("items",c.getTotal_Items());
		session.setAttribute("items",c.getTotal_Items());
		session.setAttribute("cartId",c.getCart_Id());
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);
		return "Viewcart";
}
//	else
//	{
		return "redirect:/viewcart";
//	}
}
@RequestMapping(value="/Remove/{Cartitem_Id}")
public ModelAndView RemoveFromCart(@PathVariable("Cartitem_Id") String id)
{
	ModelAndView obj =new ModelAndView("redirect:/viewcart");
	cartItems =cartItemDao.get(id);
	Cart c=cartItems.getCart();
	c.setGrand_Total(c.getGrand_Total()-cartItems.getPrice());
	c.setTotal_Items(c.getTotal_Items()-1);
	cartDao.saveorupdate(c);
	
	cartItemDao.delete(cartItems);
	return obj;
}
@RequestMapping(value="/Removeall")
public String RemoveallFromCart(Model model,HttpSession session)
{
	Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
		String currusername= authentication.getName();
		User u =userDao.getUseremail(currusername);
		Cart c= cartDao.get(u.getCart().getCart_Id());
		List<CartItems> cartItem=cartItemDao.getlist(u.getCart().getCart_Id());
		for(CartItems g:cartItem)
		{
			cartItemDao.delete(g);
		}
		c.setGrand_Total(0.0);
		c.setTotal_Items(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items", c.getTotal_Items());
		return "redirect:/viewcart";
}
	else
	{
		return "redirect:/";
	}
}}
