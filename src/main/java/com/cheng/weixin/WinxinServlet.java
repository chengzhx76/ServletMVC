package com.cheng.weixin;

import com.alibaba.fastjson.JSON;
import com.cheng.servletmvc.BaseServlet;
import com.cheng.utils.HttpUtils;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Desc: http://localhost/ServletMVC/weixin?method=laodingPage&url=one
 *       http://chengzhx76.wicp.net/ServletMVC/weixin?method=laodingPage&url=one
 * Author: hp
 * Date: 2017/3/24
 */
public class WinxinServlet extends BaseServlet {
    public void handleMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reqMethod =  request.getMethod();
        if ("POST".equals(reqMethod)) {

            log.info("===================");

        }else {
            initWx(request, response);
        }
    }

    public String laodingPage(HttpServletRequest request, HttpServletResponse response) {
        Enumeration en = request.getParameterNames();
        while(en.hasMoreElements()){
            String el = en.nextElement().toString();
            System.out.println(el+"="+request.getParameter(el));
        }
        return "weixin/loading";
    }

    public String one(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        log.info("code--------------> "+code);
        String openId = request.getParameter("openId");

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("openId")) {
                openId = cookie.getValue();
            }
        }
        log.info("openId--------------> "+openId);

        if(Strings.isNullOrEmpty(code) && Strings.isNullOrEmpty(openId)) {
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcabea2c14e5861ec"+
                    "&redirect_uri=http%3A%2F%2Fchengzhx76.wicp.net%2FServletMVC%2Fweixin%3Fmethod%3Done"+
                    "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
        }

        if (!Strings.isNullOrEmpty(code)) {
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcabea2c14e5861ec&secret=d4624c36b6795d1d99dcf0547af5443d&code="
                    +code+"&grant_type=authorization_code";
            String wxUser = HttpUtils.doGet(url);
            log.info(wxUser);
            Map<String, String> map = JSON.parseObject(wxUser, Map.class);
            request.setAttribute("info", "微信上获取的");
            request.setAttribute("openId", map.get("openid"));
        }else if (!Strings.isNullOrEmpty(openId)) {
            request.setAttribute("info", "缓存的");
            request.setAttribute("openId", openId);
        }
        return "weixin/one";
    }

    public String wxPage(HttpServletRequest request, HttpServletResponse response) {
        Enumeration en = request.getParameterNames();
        while(en.hasMoreElements()){
            String el = en.nextElement().toString();
            System.out.println(el+"="+request.getParameter(el));
        }

        return "index";
    }


    /** 初始化微信 **/
    private void initWx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if (Strings.isNullOrEmpty(signature)
                && Strings.isNullOrEmpty(timestamp)
                && Strings.isNullOrEmpty(nonce)
                && Strings.isNullOrEmpty(echostr)) {
            log.info("参数不完整");
            return;
        }

        String[] wxParam = {"chengzhx76", timestamp, nonce};
        Arrays.sort(wxParam);
        StringBuilder allParam = new StringBuilder();
        for (String param : wxParam) {
            allParam.append(param);
        }
        String paramSha1 = Hashing.sha1().hashString(allParam.toString(), Charset.defaultCharset()).toString();

        if (paramSha1.equals(signature)) {
            response.getWriter().write(echostr);
        }else {
            response.getWriter().write("ERROR");
        }
    }

}
