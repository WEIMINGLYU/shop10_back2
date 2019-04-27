package com.ai.shop10_back.po;

import java.util.List;

/*一级类目扩展类Dao*/
public class CategoryExt extends Category {
    List<CategorysecondExt> categorysecondExtList;

    public List<CategorysecondExt> getCategorysecondExtList() {
        return categorysecondExtList;
    }

    public void setCategorysecondExtList(List<CategorysecondExt> categorysecondExtList) {
        this.categorysecondExtList = categorysecondExtList;
    }
}
