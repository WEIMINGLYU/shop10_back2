package com.ai.shop10_back.service.impl;

import com.ai.shop10_back.dao.ICategoryDao;
import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.CategoryExt;
import com.ai.shop10_back.po.Categorysecond;
import com.ai.shop10_back.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {

    @Resource
    private ICategoryDao categoryDao;
    @Override
    public List<CategoryExt> getAllCAndCs() {
        return categoryDao.getAllCAndCs();
    }

    /*查询所有一级类目*/
    public List<Category> findByCategory() {
       return categoryDao.findByCategory();
    }

}
