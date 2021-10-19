package com.project.mallproject.core.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Description: 应该用不上，直接sendRedirect
 * date: 2021/10/19 10:00 上午
 *
 * @author lixn
 */
@Deprecated
@Component
public class OkHttpSingleton {
    private static Logger logger = CommonUtil.createLogger(OkHttpSingleton.class);

    public static final OkHttpClient me = new OkHttpClient();

//    public String get(String url, Map<String, String> params) {
//        Response responseBody = null;
//
//        if (params != null && params.keySet().size() > 0) {
//            Request request = new Request.Builder()
//                    .url(url)
//                    .build();
//            try {
//                responseBody = me.newCall(request).execute();
//            } catch (Exception e) {
//                System.out.println("");
//            }
//        }
//    }
//
//    public String post(String url, Map<String, String > params) {
//        return null;
//    }

//    public String get(String url, Map<String, String> queries) {
//        String responseBody = "";
//        StringBuffer sb = new StringBuffer(url);
//        if (queries != null && queries.keySet().size() > 0) {
//            boolean firstFlag = true;
//            Iterator iterator = queries.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
//                if (firstFlag) {
//                    sb.append("?" + entry.getKey() + "=" + entry.getValue());
//                    firstFlag = false;
//                } else {
//                    sb.append("&" + entry.getKey() + "=" + entry.getValue());
//                }
//            }
//        }
//        Request request = new Request.Builder()
//                .url(sb.toString())
//                .build();
//        try (Response response = okHttpClient.newCall(request).execute()) {
//            int status = response.code();
//            if (status == 200) {
//                return response.body().string();
//            }
//        } catch (Exception e) {
//            logger.error("okhttp put error >> ex = {}", (Object) e.getStackTrace());
//        }
//        return responseBody;
//    }
//
//    public String post(String url, Map<String, String> params) {
//        String responseBody = "";
//        FormBody.Builder builder = new FormBody.Builder();
//        //添加参数
//        if (params != null && params.keySet().size() > 0) {
//            for (String key : params.keySet()) {
//                builder.add(key, params.get(key));
//            }
//        }
//        Request request = new Request
//                .Builder()
//                .url(url)
//                .post(builder.build())
//                .build();
//        try (Response response = okHttpClient.newCall(request).execute()) {
//            int status = response.code();
//            if (status == 200) {
//                return response.body().string();
//            }
//        } catch (Exception e) {
//            logger.error("okhttp post error >> ex = {}", (Object) e.getStackTrace());
//        }
//        return responseBody;
//    }
}
