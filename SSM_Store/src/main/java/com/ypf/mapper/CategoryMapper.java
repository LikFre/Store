package com.ypf.mapper;

import java.util.List;

import com.ypf.entity.Category;

public interface CategoryMapper {
	//查找所有分类
	List<Category> findCategory();

}
