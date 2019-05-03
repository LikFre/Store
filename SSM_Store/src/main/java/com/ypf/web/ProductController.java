package com.ypf.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypf.entity.Product;
import com.ypf.mapper.ProductMapper;
import com.ypf.service.ProductService;
import com.ypf.utils.PageModel;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;
	//通过商品id查找商品
	@RequestMapping("/getproduct.do")
	public String GetProduct(String pid,Model model) {
		Product product=productService.getProductById(pid);
		model.addAttribute("pro",product);
		return "product_info";
	}
	
	@RequestMapping("/cate_products.do")
	//按类别查找商品
	public String GetProductsByCate(String cid,int num,Model model) {
		PageModel page=productService.getProductsByCId(cid,num);
		model.addAttribute("page",page);
		return "product_list";
	}
}
