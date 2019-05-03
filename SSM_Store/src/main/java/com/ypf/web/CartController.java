package com.ypf.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypf.entity.Cart;
import com.ypf.entity.CartItem;
import com.ypf.entity.Product;
import com.ypf.entity.User;
import com.ypf.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Resource
	private ProductService productService;
	@Resource
	private CartItem cartitem;
	//添加购物车
	@RequestMapping("/AddCart.do")
	public String AddCart(HttpSession session,String pid,int num,Model model) {
		Cart cart=(Cart) session.getAttribute("cart");
		if(null==cart) {
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		User user=(User) session.getAttribute("loginUser");
		if(null==user) {
			model.addAttribute("msg", "用户还未登录，请登录之后再添加");
			return "info";
		}
		Product pro=productService.getProductById(pid);
		
		CartItem cartitem=new CartItem();
		cartitem.setProduct(pro);
		cartitem.setNum(num);
		
		cart.addCarts(cartitem);
		
		return "redirect:/cart/toCart.do";
	}
	//删除购物车的某一项
	@RequestMapping("/deletecart.do")
	public String DeleteCart(HttpSession session,String pid) {
		Cart cart=(Cart) session.getAttribute("cart");
		cart.delCart(pid);
		return "cart";
	}
	//清空购物车
	@RequestMapping("/clearCart.do")
	public String ClearCart(HttpSession session) {
		Cart cart=(Cart) session.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	//跳转到购物车页面
	@RequestMapping("/toCart.do")
	public String toCart() {
		return "cart";
	}
}
