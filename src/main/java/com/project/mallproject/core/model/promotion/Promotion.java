package com.project.mallproject.core.model.promotion;

import com.project.mallproject.core.model.product.Product;

import java.util.List;

/**
 * Description:
 * date: 2021/10/18 10:54 上午
 *
 * @author lixn
 */
public class Promotion {
    private String id; // 促销活动id
    private String description; // 促销活动描述（文本）
    private List<Product> products; // 参与促销的产品
    private String updateTime; // 活动上架时间
    private String pastTime; // 活动下架时间
}
