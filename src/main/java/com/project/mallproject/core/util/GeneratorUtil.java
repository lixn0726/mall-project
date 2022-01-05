package com.project.mallproject.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
/**
 * Description:
 * date: 2021/10/26 5:30 下午
 *
 * @author lixn
 */
public class GeneratorUtil {
    /**
     *  将字符串去下划线，改为驼峰式命名
     */
    public static String getNoUnderlineStr(String strKey) {
        if (strKey.contains("_")) {
            String[] keyArray = strKey.split("_");
            StringBuffer sb = new StringBuffer();
            boolean flag = false;
            for (String key : keyArray) {
                if (flag) {
                    sb.append(StringUtils.capitalize(key));
                } else {
                    flag = true;
                    sb.append(key);
                }
            }
            strKey = sb.toString();
        }
        return strKey;
    }

    /**
     * 去掉字符串指定的前缀
     */
    public static String removePrefix(String str, String[] prefix) {
        if (StringUtils.isEmpty(str)) {
            return "";
        } else {
            if (null != prefix) {
                String[] prefixArray = prefix;

                for(int i = 0; i < prefix.length; ++i) {
                    String pf = prefixArray[i];
                    if (str.toLowerCase().matches("^" + pf.toLowerCase() + ".*")) {
                        return str.substring(pf.length());
                    }
                }
            }

            return str;
        }
    }

    /**
     * 格式化时间
     */
    public static String getFormatTime(String pattern, Date date) {
        SimpleDateFormat sdf =new SimpleDateFormat(pattern);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return sdf.format(date ==null ?new Date() : date);
    }
}
