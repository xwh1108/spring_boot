package com.xie.web;

import com.github.pagehelper.PageInfo;
import com.xie.pojo.Product;
import com.xie.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Product> pageInfo = productService.findAll(page, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("products",pageInfo.getList());
        return "datalist";
    }
}
