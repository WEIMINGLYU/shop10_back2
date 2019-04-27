package com.ai.shop10_back.util;


import com.ai.shop10_back.po.CategoryExt;
import com.ai.shop10_back.service.ICategoryService;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class CategoryUtil {
 public static CategoryUtil categoryUtil;
 @PostConstruct
 public void init(){
     categoryUtil = this;
 }



 @Resource
 private ICategoryService categotyService;

 public List<CategoryExt> searchCategoryAndSecond(){
        return categotyService.getAllCAndCs();
 }

}
