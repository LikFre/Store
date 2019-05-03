package com.ypf.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypf.entity.Category;
import com.ypf.service.CategoryService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	//查找所有分类
	@RequestMapping("/findcategory.do")
	public String findcategory(HttpServletResponse response) throws Exception {
		List<Category> list=categoryService.findcategory();
		//返回响应类型为json格式
		JSONArray jsonArray=JSONArray.fromObject(list);
		String json=jsonArray.toString();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}
}
