package com.ypf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ypf.entity.Category;
import com.ypf.mapper.CategoryMapper;
import com.ypf.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Resource
	private CategoryMapper categoryMapper;
	public List<Category> findcategory() {
		List<Category> list=categoryMapper.findCategory();
		return list;
	}

}
