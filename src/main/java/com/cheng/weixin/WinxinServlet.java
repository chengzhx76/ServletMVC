package com.cheng.weixin;

import com.cheng.servletmvc.BaseServlet;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Desc:
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

        String[] wxParam = {"wechat", timestamp, nonce};
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
