package com.ypf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ypf.entity.Product;
import com.ypf.mapper.ProductMapper;
import com.ypf.service.ProductService;
import com.ypf.utils.PageModel;
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;
	public List<Product> getNewProduct() {
		List<Product> list=productMapper.getNewProduct();
		while(list.size()>9) {
			list.remove(9);
		}
		return list;
	}
	public List<Product> getHotNewProduct() {
		List<Product> list=productMapper.getHotNewProduct();
		while(list.size()>9) {
			list.remove(9);
		}
		return list;
	}
	public Product getProductById(String pid) {
		Product product=productMapper.getProductById(pid);
		return product;
	}
	//按类别查找
	public PageModel getProductsByCId(String cid,int num) {
		int total=productMapper.getTotalProducts(cid);
		PageModel pg=new PageModel(num,total,11);
		List<Product> list=productMapper.getProducts(cid,pg.getStartIndex(),pg.getPageSize());
		pg.setList(list);
		pg.setUrl("/product/cate_products.do?cid="+cid);
		return pg;
	}
}
