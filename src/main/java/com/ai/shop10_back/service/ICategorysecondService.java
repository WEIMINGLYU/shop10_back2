package com.ai.shop10_back.service;

import com.ai.shop10_back.po.Categorysecond;

import java.util.List;

public interface ICategorysecondService {
    /*查询所有二级类目*/
    List<Categorysecond> findByCategorysecond(Integer cid);
    /*回显一级类目*/
    int findCidByCsid(Integer csid);
}
