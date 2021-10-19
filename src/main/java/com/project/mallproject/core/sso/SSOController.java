//package com.project.mallproject.core.sso;
//
//import cn.hutool.core.bean.BeanUtil;
//import org.apache.tomcat.util.buf.StringUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.UUID;
//
///**
// * Description:
// * date: 2021/10/19 11:32 上午
// *
// * @author lixn
// */
//public class SSOController {
//    public static final String REDIS_USER_TOKEN = "redis_user_token";
//    public static final String REDIS_USER_TICKET = "redis_user_ticket";
//
//    public static final String REDIS_TMP_TICKET = "redis_tmp_ticket";
//    public static final String COOKIE_USER_TICKET = "cookie_user_ticket";
//
//    @GetMapping("/login")
//    public String login(String back, HttpServletRequest request, HttpServletResponse response) {
//        // 1.获取userTicket门票，如果cookie中能获取到，证明用户登陆过，此时签发一个一次性的 临时票据并且回跳
//        String userTicket = getCookie(request, COOKIE_USER_TICKET);
//        boolean isVerified = verifyUserTicket(userTicket);
//        if (isVerified) {
//            String tmpTicket = createTmpTicket();
//            return "redirect:" + back + "?tmpTicket=" + tmpTicket;
//        }
//
//        // 2.用户从未登陆过，第一次进入则跳转到CAS的统一登陆页面
//        return "login";
//    }
//
//    private boolean verifyUserTicket(String userTicket) {
//        // CAS门票不能为空
//        if (StringUtils.isBlank(userTicket)) {
//            return false;
//        }
//
//        // 验证CAS门票是否有效
//        String userId = redisOperator.get(REDIS_USER_TICKET + ":" + userTicket);
//        if (StringUtils.isBlank(userId)) {
//            return false;
//        }
//
//        // 验证门票对应的user会话是否存在
//        String userRedis = redisOperator.get(REDIS_USER_TOKEN + ":" + userId);
//        if (StringUtils.isBlank(userRedis)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    /*
//     * CAS统一登陆接口
//     */
//    @PostMapping("/doLogin")
//    public String doLogin(String username, String password, String back, HttpServletRequest request, HttpServletResponse response) {
//        // todo 1、username、password判空
//        // todo 2、查库实现登陆
//        // 3、登陆成功，实现用户的redis会话
//        String uniqueToken = UUID.randomUUID().toString().trim();
//        UserResult result = new UserResult(); // 登陆结果
//        UserVo userVo = new UserVo();
//        BeanUtils.copyProperties(request, userVo);
//        redisOperator.set(REDIS_USER_TOKEN + ":" + request.getId(),
//                objectToJson(userVo)); // redis保存user该次会话
//        // 4、生成ticket门票，全局门票，代表用户在CAS端登陆过
//        String userTicket = UUID.randomUUID().toString().trim();
//
//        // 5、全局门票放入CAS端的cookie中
//        setCookie(COOKIE_USER_TICKET, userTicket, response);
//
//        // 6、userTicket关联用户id，并且放入到redis中，代表这个用户有门票了，可以到处去玩
//        redisOperator.set(REDIS_USER_TICKET + ":" + userTicket, result.getId());
//
//        // 7、生成临时票据，回调到调用段网站，由CAS端所签发的一个 一次性 的临时ticket
//        String tmpTicket = createTmpTicket();
//        return "redirect:" + back + "?tmpTicket=?" + tmpTicket;
//    }
//
//    @PostMapping("/verifyTmpTicket")
//    public String verifyTmpTicket(String tmpTicket, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        // todo 可以把这里修改成 <责任链模式>，后续修改也方便一点
//        // 使用一次性 临时票据来验证用户是否登陆，如果登陆过，把用户会话信息返回给站点
//        // 使用完毕后，需要销毁临时票据
//        String tmpTicketValue = redisOperator.get(REDIS_TMP_TICKET + ":" + tmpTicket);
//        if (StringUtils.isBlank(tmpTicketValue)) {
//            System.out.println("用户票据异常");
//        }
//
//        // 1、如果临时票据OK，则需要销毁，并且拿到CAS端cookie中的全局userTicket，以此再获取用户会话
//        // todo 将tmpTicket进行加密后再进行比较
//        if (!tmpTicketValue.equals(tmpTicket)) {
//            System.out.println("用户票据异常");
//        } else {
//            redisOperator.del(REDIS_TMP_TICKET + ":" + tmpTicket);
//        }
//        // 2、验证并获取用户的userTicket
//        String userTicket = getCookie(request, COOKIE_USER_TICKET);
//        String userId = redisOperator.get(REDIS_USER_TICKET + ":" + userTicket);
//        if (stringUtils.isBlank(userId)) {
//            System.out.println("用户票据异常");
//        }
//        // 3、验证门票对应的user会话是否存在
//        String userRedis = redisOperator.get(REDIS_USER_TOKEN + ":" + userTicket);
//        if (stringUtils.isBlank(userRedis)) {
//            System.out.println("用户票据异常");
//        }
//    }
//
//    /*
//     * 创建临时票据
//     */
//    private String createTmpTicket() {
//        String tmpTicket = UUID.randomUUID().toString().trim();
//        try {
//            // todo 将临时票据放入redis，并且设置过期时间
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return tmpTicket;
//    }
//
//    /*
//     * 设置cookie
//     */
//    private void setCookie(String key, String val, HttpServletResponse response) {
//        Cookie cookie = new Cookie(key, val);
//        cookie.setDomain("sso.com");
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }
//
//
//
//}
