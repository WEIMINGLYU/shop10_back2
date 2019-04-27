package com.ai.shop10_back.controller;

import com.ai.shop10_back.po.Category;
import com.ai.shop10_back.po.CategoryExt;
import com.ai.shop10_back.po.Product;
import com.ai.shop10_back.service.ICategoryService;
import com.ai.shop10_back.service.ICategorysecondService;
import com.ai.shop10_back.service.IProductService;
import com.ai.shop10_back.util.PageBeanForProduct;
import com.ai.shop10_back.util.UpFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/product")
@Controller
public class ProductController {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private ICategorysecondService categorysecondService;
    @Resource
    private IProductService productService;
    @Resource
    private HttpServletRequest request;

    /*全部商品显示页*/
    @RequestMapping("allProduct")
    public String allProduct(PageBeanForProduct<Product> pageBeanForProduct, Model model) {
        if (pageBeanForProduct.getPname()!=null&&!"".equals(pageBeanForProduct.getPname().trim())) {
            pageBeanForProduct.setPname(pageBeanForProduct.getPname().trim());
        }
        if (pageBeanForProduct.getCid()!=null&&!"0".equals(pageBeanForProduct.getCid())){
            pageBeanForProduct.setCid(pageBeanForProduct.getCid());
        }
        if (pageBeanForProduct.getCsid()!=null&&!"0".equals(pageBeanForProduct.getCsid())){
            pageBeanForProduct.setCsid(pageBeanForProduct.getCsid());
        }
        String delMsg = (String) model.asMap().get("delMsg");
        model.addAttribute("delMsg", delMsg);
        /*遍历所有商品*/
        PageBeanForProduct<Product> allProduct = productService.findAllProduct(pageBeanForProduct);

        model.addAttribute("allProduct", allProduct);
        /*显示一二级类目*/
        List<CategoryExt> allCAndCs = categoryService.getAllCAndCs();
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("allCAndCs", allCAndCs);
        List<Category> byCategory = categoryService.findByCategory();
        model.addAttribute("byCategory",byCategory);
        return "index";
    }

    /*添加商品页面入口*/
    @RequestMapping("updateNews")
    public String updateNews() {
        return "updateNews";
    }

    /*添加商品*/
    @RequestMapping("addProduct")
    public String addProduct( MultipartFile photo, Product product) throws ParseException {

        /*product.setCsid(Integer.parseInt(request.getParameter("csid_"+cid)));*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        product.setPdate(df.parse(df.format(new Date())));
        product.setIs_hot(0);
        //获取服务器绝对路径
        ServletContext appliContext = request.getServletContext();
       String realPath = appliContext.getRealPath("/upload");
        //获取文件名
        String fileName = photo.getOriginalFilename();
        String imagePath = UpFile.upFile(fileName, realPath,photo);
        product.setImage(imagePath);
        productService.addProduct(product);
        return "redirect:/product/allProduct";
    }

    /*删除商品*/
    @RequestMapping("delProduct")
    public String delProduct(Integer pid, PageBeanForProduct<Product> pageBeanForProduct, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");

        productService.delProduct(pid,realPath);

        return "forward:/product/allProduct";
    }

    /*先查寻商品是否被用过*/
    @RequestMapping("findByPid")
    public void findByPid(HttpServletResponse response, Integer pid) throws IOException {

        Integer i = productService.productByOrderitem(pid);

        if (i == 0) {
            response.getWriter().print("ok");
        } else {
            response.getWriter().print("no");
        }

    }
    /*商品回显*/
    @RequestMapping("findProductByPid")
    public String findProductByPid(Integer pid,PageBeanForProduct<Product> pageBeanForProduct,Model model){
        Product productByPid = productService.findProductByPid(pid);
        int csid = productByPid.getCsid();
        int cidByCsid = categorysecondService.findCidByCsid(csid);
        model.addAttribute("product",productByPid);
        model.addAttribute("cid",cidByCsid);
        model.addAttribute("pid",pid);
        return "updateProduct";
    }

    /*修改商品信息*/
    @RequestMapping("updateProduct")
    public String updateProduct(Product product,MultipartFile photo){
        String imageProduct = productService.findImageByPid(product);
        //获取服务器绝对路径
        ServletContext appliContext = request.getServletContext();
        String realPath = appliContext.getRealPath("/upload");
        String substring = imageProduct.substring(imageProduct.lastIndexOf("/"));

        //获取文件名
        String fileName = photo.getOriginalFilename();
        /*判断是否上传了图片*/
        if (photo.isEmpty()){
            product.setImage(imageProduct);
            productService.updateProduct(product);
        }else {
            File file = new File(realPath+substring);
            file.delete();
            String imagePath = UpFile.upFile(fileName, realPath,photo);
            product.setImage(imagePath);
        }
        productService.updateProduct(product);
       return "forward:/product/allProduct";
    }
}
