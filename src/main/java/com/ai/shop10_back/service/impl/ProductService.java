package com.ai.shop10_back.service.impl;

import com.ai.shop10_back.dao.IProductDao;
import com.ai.shop10_back.po.Product;
import com.ai.shop10_back.service.IProductService;
import com.ai.shop10_back.util.PageBeanForProduct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.io.File;
import java.util.List;
@Transactional
@Service
public class ProductService implements IProductService {
    @Resource
    private IProductDao productDao;

    @Override
    public PageBeanForProduct<Product> findAllProduct(PageBeanForProduct<Product> PageBeanForProduct) {
        if (PageBeanForProduct.getPname() != null) {
            PageBeanForProduct.setPname(PageBeanForProduct.getPname().trim());
        }
        int pageSize = 12;
        PageBeanForProduct.setPageSize(pageSize);
        /*返回总记录数*/
        int rowCount = productDao.getProductCount(PageBeanForProduct);
        PageBeanForProduct.setRowCount(rowCount);
        /*该类目下无商品*/
        if (rowCount == 0) {
            return null;
        }
        /*封装pageCount*/
        int pageCount = 0;
        if (rowCount % pageSize == 0) {
            pageCount = rowCount / pageSize;
        } else {
            pageCount = rowCount / pageSize + 1;
        }
        PageBeanForProduct.setPageCount(pageCount);
        /*封装pageNow*/
        if (PageBeanForProduct.getPageNow()==null) {
            PageBeanForProduct.setPageNow(1);
        }
      int pageNow = PageBeanForProduct.getPageNow();


        if (pageNow < 1) {
            PageBeanForProduct.setPageNow(1);
        } else if (pageNow > pageCount) {
            PageBeanForProduct.setPageNow(pageCount);
        }
        /*封装starLimit*/
        int limit = 0;

            limit = (PageBeanForProduct.getPageNow() - 1) * pageSize;
            PageBeanForProduct.setStartLimit(limit);

        /*封装List*/
        List<Product> products = productDao.findAllProduct(PageBeanForProduct);
        PageBeanForProduct.setList(products);
        /*处理Pname的百分号*/

        return PageBeanForProduct;
    }
     /*添加商品*/
    @Override
    public void addProduct(Product product) {
          productDao.addProduct(product);
    }

    /*删除商品*/
    @Override
    public void delProduct(Integer pid,String path) {
        /*通过商品ID查询商品图片地址*/
        String image = productDao.findImage(pid);
        File file = new File(path+image);
        file.delete();
         productDao.delProduct(pid);
    }

    @Override
    public Integer productByOrderitem(Integer pid) {

        return productDao.productByOrderitem(pid);
    }
    /*修改页回显*/
    @Override
    public Product findProductByPid(Integer pid) {
        return  productDao.findProductByPid(pid);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public String findImageByPid(Product product) {
        return productDao.findImageByPid(product);
    }

}
