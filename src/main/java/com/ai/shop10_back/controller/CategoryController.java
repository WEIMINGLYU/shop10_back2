package com.ai.shop10_back.controller;

import com.ai.shop10_back.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/category")
@Controller
public class CategoryController {
    @Resource
    private ICategoryService categoryService;



}
