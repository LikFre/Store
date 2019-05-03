package com.ypf.web;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypf.entity.Cart;
import com.ypf.entity.CartItem;
import com.ypf.entity.Order;
import com.ypf.entity.OrderItem;
import com.ypf.entity.User;
import com.ypf.service.OrderService;
import com.ypf.utils.PageModel;
import com.ypf.utils.UUIDUtils;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Resource
	private OrderService orderService;
	//保存订单
	@RequestMapping("/saveorder.do")
	public String Saveorder(HttpSession session,Model model) {
		User user=(User) session.getAttribute("loginUser");
		Cart cart=(Cart) session.getAttribute("cart");
		Order order=orderService.SaveOrder(user,cart);
		model.addAttribute("order", order);
		cart.clearCart();
		return "order_info";
	}
	//通过用户id查找订单
	@RequestMapping("/findByUid.do")
	public String findByUid(HttpSession session,Model model,int num) {
		User user=(User) session.getAttribute("loginUser");
		PageModel pg=orderService.FindOrderByUid(user.getUid(),num);
		model.addAttribute("page", pg);
		//System.out.println(pg.getList());
		return "order_list";
	}
	//通过订单id查找订单
	@RequestMapping("/ByOid.do")
	public String findByOid(Model model,String oid) {
		Order order=orderService.FindOrderByOid(oid);
		model.addAttribute("order", order);
		return "order_info";
	}
}
