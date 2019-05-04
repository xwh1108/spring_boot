package com.xie.web;

import com.github.pagehelper.PageInfo;
import com.xie.pojo.Product;
import com.xie.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize,
                          @RequestParam(name = "key",defaultValue = "") String key){
        PageInfo<Product> pageInfo = productService.findAll(page, pageSize,key);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("products",pageInfo.getList());
        return "datalist";

    }
    @PostMapping("findAll")
    public String selectAll(Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize,
                          @RequestParam(name = "key",defaultValue = "") String key){
        PageInfo<Product> pageInfo = productService.findAll(page, pageSize,key);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("products",pageInfo.getList());
        return "datalist::table_refresh";

    }

    @RequestMapping("del")
    public String del(@RequestParam(name = "ids") List<Integer> ids){
        for (Integer id : ids) {
            productService.delById(id);
        }
        return "redirect:/product/findAll";
    }

    @PostMapping("add")
    public String add(Product product){
        productService.add(product);
        return "redirect:findAll";
    }
    @GetMapping("add")
    public String toAdd(){
        return "product-add";
    }

    @GetMapping("update/{id}")
    public String toUpdate(@PathVariable(name = "id") Integer id,Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    @PostMapping("update")
    public String update(Product product){
        productService.update(product);
        return "redirect:findAll";
    }

}
