package com.ai.shop10_back.controller;

import com.ai.shop10_back.po.Categorysecond;
import com.ai.shop10_back.service.ICategorysecondService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/categorysecond")
@Controller
public class CategorysecondController {
    @Resource
    private ICategorysecondService categorysecondService;
    @ResponseBody
    @RequestMapping("findCategorysecond")
    public String findCategorysecond(Integer cid, HttpServletResponse response) throws IOException {
        List<Categorysecond> byCategorysecond = categorysecondService.findByCategorysecond(cid);
        for (Categorysecond categorysecond : byCategorysecond) {
            categorysecond.setCsname(URLEncoder.encode(categorysecond.getCsname()));
        }
         return JSON.toJSONString(byCategorysecond);
    }
}
