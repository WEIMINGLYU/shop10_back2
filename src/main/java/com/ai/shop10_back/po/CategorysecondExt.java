package com.ai.shop10_back.po;

import java.util.List;

public class CategorysecondExt extends Categorysecond{
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
