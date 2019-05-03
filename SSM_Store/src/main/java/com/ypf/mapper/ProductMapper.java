package com.ypf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ypf.entity.Product;


public interface ProductMapper {
	//查找最新的产品
	List<Product> getNewProduct();
	//查找最新热门的商品
	List<Product> getHotNewProduct();
	//通过商品id查找商品
	Product getProductById(String pid);
	//按类别查找商品总数
	int getTotalProducts(String cid);
	//通过分类id查找商品
	List<Product> getProducts(@Param("cid")String cid,@Param("start")int start,@Param("size")int size);

}
