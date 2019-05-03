package com.ypf.entity;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
//购物项,对应购物车中的一个红色框
public class CartItem {
	private Product product; //商品对象
	private int num; //数量
	private double subTotal; //小计
	
	//小计是经过计算获取
	public double getSubTotal() {
		return product.getShop_price()*num;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num + ", subTotal=" + subTotal + "]";
	}
	
}
