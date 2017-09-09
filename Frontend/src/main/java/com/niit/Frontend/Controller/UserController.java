package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.Dao.BillingDao;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.Billing;
import com.niit.Backend.Model.Cart;
import com.niit.Backend.Model.User;

@Controller
public class UserController {
@Autowired
User user;
@Autowired
UserDao userDao;
@Autowired
Billing billing;
@Autowired
BillingDao billingdao;
@RequestMapping("/user")
public ModelAndView User() {
	ModelAndView obj=new ModelAndView("User");
	user.setBilling(billing);
	obj.addObject("user",new User());
	List<User> li=userDao.list();
	obj.addObject("users",li);
	return obj;	
}
@RequestMapping("/adduser")
public ModelAndView adduser(@ModelAttribute("user")User user) {
	ModelAndView obj=new ModelAndView("redirect:/");
	Cart cart= new Cart();
	user.setCart(cart);
	
	if(userDao.saveorupdate(user)==true) {
	
		obj.addObject("msg1","user added successfully");
	}
	else {
		obj.addObject("msg2","user not added");
	}
	return obj;
}

}
