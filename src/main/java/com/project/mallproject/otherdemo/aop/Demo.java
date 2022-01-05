package com.project.mallproject.otherdemo.aop;

import com.project.mallproject.core.annotation.SysLog;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 * date: 2021/10/26 11:41 上午
 *
 * @author lixn
 */
public class Demo {
    @Autowired
    private BuyAspect buyAspect;

    @As
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.buy(111);
    }
}
