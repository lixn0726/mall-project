package com.project.mallproject.core.model.order;

import com.project.mallproject.core.model.coupon.Coupon;
import com.project.mallproject.core.model.product.Product;
import com.project.mallproject.core.model.user.User;

import java.util.List;

/**
 * Description:
 * date: 2021/10/18 10:38 上午
 *
 * @author lixn
 */
public class OrderDetail {
    private List<Product> products;
    private float summarizePrice;
    private float actualPrice;
    private List<Coupon> coupons;
    private String submitTime;
    private boolean isReturn;
    private User customer;

}
