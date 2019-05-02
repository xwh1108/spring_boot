package com.xie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.mapper.ProductMapper;
import com.xie.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public PageInfo<Product> findAll(Integer page, Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Product> products = productMapper.selectAll();
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        return pageInfo;
    }
}
