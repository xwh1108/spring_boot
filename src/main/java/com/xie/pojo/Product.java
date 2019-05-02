package com.xie.pojo;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@NameStyle(Style.normal)
@Table(name = "product")
public class Product {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private Date departureTime; // 出发时间
    @Transient
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus;// 状态 0 关闭 1 开启
    @Transient
    private String productStatusStr;
}