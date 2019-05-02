package com.xie.mapper;

import com.xie.SpringBootSsmApplication;
import com.xie.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSsmApplication.class)
public class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void demo(){
        List<Product> products = productMapper.selectAll();
        for (Product product : products) {
            System.out.println("product = " + product);
        }
    }
}