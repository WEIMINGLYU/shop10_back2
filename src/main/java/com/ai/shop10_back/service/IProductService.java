package com.ai.shop10_back.service;

import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.Product;
import com.ai.shop10_back.util.PageBeanForProduct;

import java.util.List;

public interface IProductService {

    PageBeanForProduct<Product> findAllProduct(PageBeanForProduct<Product> PageBeanForProduct);
   /*添加商品*/
    void addProduct(Product product);
    /*删除商品*/
    void delProduct(Integer pid,String image);
    /*查询订单中是否有该商品*/
    Integer productByOrderitem(Integer pid);

    /*修改页回显*/
    Product findProductByPid(Integer pid);

    /*修改商品信息*/
    void updateProduct(Product product);
    /*查询要修改的PID的图片信息*/
      String findImageByPid(Product product);
}
