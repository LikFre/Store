package com.ypf.service;

import java.util.List;

import com.ypf.entity.Product;
import com.ypf.utils.PageModel;

public interface ProductService {
	//查找最新的产品
	List<Product> getNewProduct();
	//查找最新热门的商品
	List<Product> getHotNewProduct();
	//通过商品id查找商品
	Product getProductById(String pid);
	//通过分类id查找商品
	PageModel getProductsByCId(String cid,int num);

}
