package com.ypf.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ypf.entity.Cart;
import com.ypf.entity.CartItem;
import com.ypf.entity.Order;
import com.ypf.entity.OrderItem;
import com.ypf.entity.User;
import com.ypf.mapper.OrderMapper;
import com.ypf.service.OrderService;
import com.ypf.utils.PageModel;
import com.ypf.utils.UUIDUtils;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private Order order;
	
	@Resource
	private OrderMapper orderMapper;
	public Order SaveOrder(User user, Cart cart) {
		order.setOid(UUIDUtils.getId());
		order.setOrderTime(new Date());
		order.setState(1);
		order.setTotal(cart.getTotal());
		order.setUser(user);
		orderMapper.SaveOrder(order);
		for (CartItem cartitem: cart.getCartItems()) {
			OrderItem orderitem=new OrderItem();
			orderitem.setItemid(UUIDUtils.getId());
			orderitem.setProduct(cartitem.getProduct());
			orderitem.setQuantity(cartitem.getNum());
			orderitem.setTotal(cartitem.getSubTotal());
			orderitem.setOrder(order);
			order.getList().add(orderitem);
			orderMapper.SaveOrderItem(orderitem);
		}
		return order;
	}
	public PageModel FindOrderByUid(String uid,int num) {
		int total=orderMapper.getTotalOrderByUid(uid);
		PageModel pg=new PageModel(num,total,3);
		List<Order> list=orderMapper.getOrders(uid,pg.getStartIndex(),pg.getPageSize());
		pg.setList(list);
		pg.setUrl("/order/findByUid.do?uid="+uid);
		return pg;
	}
	public Order FindOrderByOid(String oid) {
		Order order=orderMapper.getOrderByOid(oid);
		return order;
	}
	
}
