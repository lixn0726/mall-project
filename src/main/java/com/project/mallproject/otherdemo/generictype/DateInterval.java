package com.project.mallproject.otherdemo.generictype;

import java.time.LocalDate;

/**
 * @author lixn
 * @date 2021/12/27 11:50
 **/
public class DateInterval extends Pair<LocalDate>{

    public DateInterval(LocalDate first, LocalDate second) {
        super(first, second);
    }

    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

}
