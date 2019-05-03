package com.xie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.mapper.ProductMapper;
import com.xie.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void delById(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }
    @Transactional
    public void add(Product product) {
        productMapper.insert(product);
    }

    public Product findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public void update(Product product) {
        productMapper.updateByPrimaryKey(product);
    }
}
