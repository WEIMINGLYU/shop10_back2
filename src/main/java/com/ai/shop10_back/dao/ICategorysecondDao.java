package com.ai.shop10_back.dao;

import com.ai.shop10_back.po.Categorysecond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICategorysecondDao {
    /*查询所有对应一级的二级类目*/
    List<Categorysecond> findByCategorysecond(Integer cid);
/*回显一级类目*/
    int findCidByCsid(Integer csid);
}
