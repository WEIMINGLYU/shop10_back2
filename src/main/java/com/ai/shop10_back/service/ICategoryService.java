package com.ai.shop10_back.service;

import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.CategoryExt;
import com.ai.shop10_back.po.Categorysecond;

import java.util.List;

public interface ICategoryService {

     List<CategoryExt> getAllCAndCs();
     /*查询所有一级类目*/

     List<Category> findByCategory();


}
