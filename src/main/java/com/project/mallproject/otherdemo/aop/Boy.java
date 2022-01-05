package com.project.mallproject.otherdemo.aop;

import org.springframework.stereotype.Component;

/**
 * Description:
 * date: 2021/10/26 11:35 上午
 *
 * @author lixn
 */
@Component
public class Boy implements IBuy {
    @Override
    @As
    public String buy(double price) {
        System.out.println("男孩本次消费" + price + "元");
        return "消费咯";
    }
}
