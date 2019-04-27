package com.ai.shop10_back.service.impl;

import com.ai.shop10_back.dao.ICategorysecondDao;
import com.ai.shop10_back.po.Categorysecond;
import com.ai.shop10_back.service.ICategorysecondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategorysecondService implements ICategorysecondService {
    @Resource
    private ICategorysecondDao categorysecondDao;

    /*查询所有二级类目*/
    @Override
    public List<Categorysecond> findByCategorysecond(Integer cid) {
        return categorysecondDao.findByCategorysecond(cid);
    }

    @Override
    public int findCidByCsid(Integer csid) {
        return categorysecondDao.findCidByCsid(csid);
    }
}
