package com.project.mallproject.otherdemo.generictype;

import java.time.LocalDate;

/**
 * @author lixn
 * @date 2021/12/27 11:54
 **/
public class Demo {
    public static void main(String[] args) {
        DateInterval interval = new DateInterval(LocalDate.now(), LocalDate.of(2022, 1, 1));
        Pair<LocalDate> pair = interval;
        /*
         * 中间会生成一个桥方法
         * public void setSecond(Object second) { setSecond((LocalDate) second)  }
         * 这个方法属于类 DateInterval
         */
        pair.setSecond(LocalDate.of(2023, 1, 1));
    }
}
