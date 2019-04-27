package com.ai.shop10_back.dao;

import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.Product;
import com.ai.shop10_back.util.PageBeanForProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IProductDao {
     /*全部商品分页*/
    List<Product> findAllProduct(PageBeanForProduct<Product> PageBeanForProduct);
    /*返回商品总数*/
    int getProductCount(PageBeanForProduct<Product> PageBeanForProduct);
    /*添加商品*/
    void addProduct(Product product);
    /*删除商品*/
    void delProduct(Integer pid);
    /*查询订单中是否有该商品*/
    Integer productByOrderitem(Integer pid);
    /*通过商品ID查询图片地址*/
    String findImage(Integer pid);
    /*修改页回显*/
    Product findProductByPid(Integer pid);
    /*修改商品信息*/
    void updateProduct(Product product);
    /*查询要修改的PID的图片信息*/
   String findImageByPid(Product product);
}
