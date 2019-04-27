package com.ai.shop10_back.dao;

import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.CategoryExt;
import com.ai.shop10_back.po.Categorysecond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ICategoryDao {

  List<CategoryExt> getAllCAndCs();

  /*查询所有一级类目*/
  List<Category> findByCategory();

}
