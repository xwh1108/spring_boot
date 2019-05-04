package com.xie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.mapper.ProductMapper;
import com.xie.pojo.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public PageInfo<Product> findAll(Integer page, Integer pageSize,String key){
        PageHelper.startPage(page,pageSize);
        Example example=new Example(Product.class);
        if (StringUtils.isNumeric(key)){
            example.createCriteria().orEqualTo("id",Integer.parseInt(key))
                    .orGreaterThanOrEqualTo("productPrice",Integer.parseInt(key));
        }else {
            example.createCriteria().orLike("productName","%"+key+"%")
                    .orEqualTo("cityName","%"+key+"%");
        }
        List<Product> products = productMapper.selectByExample(example);
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
