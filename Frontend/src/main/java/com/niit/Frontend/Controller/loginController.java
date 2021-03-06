package com.niit.Frontend.Controller;
	import java.util.List;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Backend.Dao.CategoryDao;
import com.niit.Backend.Dao.UserDao;
import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.User;

	@Controller
	public class loginController {

		@Autowired
		User user;
		@Autowired
		UserDao userDao;
		
		@Autowired
		Category category;
		@Autowired
		CategoryDao categoryDao;
		@RequestMapping("/login")
		public String login(@RequestParam(value="error",required=false)String error,
				@RequestParam(value="logout",required=false)String logout,Model model)
		{
			if(error!=null)
				model.addAttribute("error","invalid username or password");
			if(logout!=null)
				model.addAttribute("logout","login successfully");
			List<Category> categories= categoryDao.list();
			model.addAttribute("lcat", categories);
			return "Login";
		}
		@RequestMapping(value="/j_spring_security_check")
		public String Login(@RequestParam("j_username")String umail,@RequestParam("j_password")String pwd,Model model,HttpSession session)
	{
		User u=userDao.isValid(umail,pwd);
		if(u==null)
		{
			model.addAttribute("msg","Invalid username pwd");
			return "redirect:/";
		}
		else
		{
			session.setAttribute("user",u);
			session.setAttribute("name",u.getUname());
		session.setAttribute("items",u.getCart().getTotal_Items());
		return "redirect:/";
	}
	}
	@RequestMapping(value="/j_spring_security_logout")
	public String logout(HttpServletRequest request,HttpSession session,Model model)
	{
		session.invalidate();
		session=request.getSession(true);
		model.addAttribute("logout","logout Successfully");
		return "redirect:/";
	}
	}

