package com.cheng.servletmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc: 发送消息处理
 *
 * http://localhost/ServletMVC/index?method=index
 *
 * Author: Cheng
 * Date: 2016/3/4 0004
 */
public class SendMsg extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("===========index========ss==");
        return "index";
    }

    public String updataPage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("===========updata========ss==");
        return "updata";
    }


}
