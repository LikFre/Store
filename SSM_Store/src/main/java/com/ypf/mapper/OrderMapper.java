package com.ypf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ypf.entity.Order;
import com.ypf.entity.OrderItem;

public interface OrderMapper {
	//保存订单项
	void SaveOrderItem(OrderItem orderitem);
	//保存订单
	void SaveOrder(Order order);
	//根据用户id查找订单总数
	int getTotalOrderByUid(String uid);
	//根据用户id查找所有订单
	List<Order> getOrders(@Param("uid")String uid, @Param("start")int start, @Param("size")int size);
	//通过订单id查找订单
	Order getOrderByOid(String oid);

}
