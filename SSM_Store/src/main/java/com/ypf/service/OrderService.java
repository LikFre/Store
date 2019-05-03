package com.ypf.service;

import com.ypf.entity.Cart;
import com.ypf.entity.Order;
import com.ypf.entity.User;
import com.ypf.utils.PageModel;

public interface OrderService {
	//保存订单
	Order SaveOrder(User user, Cart cart);
	//根据用户id查订单
	PageModel FindOrderByUid(String uid,int num);
	//根据订单id查找订单
	Order FindOrderByOid(String oid);

}
