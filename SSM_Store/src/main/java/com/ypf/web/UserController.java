package com.ypf.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypf.entity.Product;
import com.ypf.entity.User;
import com.ypf.service.ProductService;
import com.ypf.service.UserService;
import com.ypf.utils.MailUtils;
import com.ypf.utils.UUIDUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private ProductService productService;
	@Resource
	private UserService userService;
	//用户注册
	@RequestMapping("/register.do")
	public String Register(User user,Model model){
		//System.out.println(user);
		try {
			//激活状态
			user.setState(0);
			//激活码
			user.setCode(UUIDUtils.getCode());
			user.setUid(UUIDUtils.getId());
			userService.UserRegister(user);
			//MailUtils.sendMail(user.getEmail(), user.getCode());
			model.addAttribute("msg", "用户注册成功");
		} catch (Exception e) {
			model.addAttribute("msg", "用户注册失败，请重新注册");
		}
		return "info";
	}
	//用户激活
	@RequestMapping("/active.do")
	public String Active(String code,Model model) {
		boolean flag=userService.UserActive(code);
		if(flag==true) {
			model.addAttribute("msg", "用户激活成功,请登录");
			return "login";
		}else {
			model.addAttribute("msg", "用户激活失败,请重新注册");
			return "info";
		}
	}
	//用户登录
	@RequestMapping("/login.do")
	public String Login(User user,HttpSession session,Model model) {
		try {
			//登录成功
			User user1=userService.UserLogin(user);
			
			session.setAttribute("loginUser", user1);
			return "redirect:/user/toindex.do";
		} catch (Exception e) {
			//用户登录失败
			String msg=e.getMessage();
			model.addAttribute("msg", msg);
			return "login";
		}
	}
		@RequestMapping("/toindex.do")
		public String toIndex(Model model) {
			List<Product> news=productService.getNewProduct();
			List<Product> hots=productService.getHotNewProduct();
			model.addAttribute("news", news);
			model.addAttribute("hots", hots);
			return "index";
		}
		@RequestMapping("/tologin.do")
		public String toLogin() {
			return "login";
		}
		@RequestMapping("/toregister.do")
		public String toRegister() {
			return "register";
		}
		@RequestMapping("/toExit.do")
		public String toExit(HttpSession session) {
			//清除Session
			session.invalidate();
			return "redirect:/user/toindex.do";
		}
		//通过用户名查找用户是否已经存在
		@RequestMapping("/getByname.do")
		public String getUserName(String username,HttpServletResponse response) throws IOException {
			String flag=userService.getUserByName(username);
			response.getWriter().print(flag);
			return null;
		}
}
