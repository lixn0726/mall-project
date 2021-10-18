package com.project.mallproject.core.model.product;

import java.util.List;

/**
 * Description:
 * date: 2021/10/18 10:37 上午
 *
 * @author lixn
 */
public class ProductDetail {
    private String brand; // 品牌
    private String type; // 分类
    private int salesVolume; // 销量
    private float price;
    private List<String> pictures;
    private List<Comment> comments;
}
