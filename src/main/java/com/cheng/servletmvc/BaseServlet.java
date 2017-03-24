package com.cheng.servletmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Desc: 基础servlet实现请求转发功能
 * Author: Cheng
 * Date: 2016/3/4 0004
 */
public class BaseServlet extends HttpServlet {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private static final String REDIRECT = "redirect:";
    private static final String PREFIX = "/WEB-INF/view/";
    private static final String SUFFIX = ".jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String reqestMethod = req.getParameter("method");
            Method method = this.getClass().getMethod(reqestMethod, HttpServletRequest.class, HttpServletResponse.class);
            String jumpPath = (String) method.invoke(this, req, resp);

            if (jumpPath!=null && !"".equals(jumpPath)) {
                if (jumpPath.startsWith(REDIRECT)) { // 客户端跳转
                    resp.sendRedirect(jumpPath.substring(REDIRECT.length()));
                }else {
                    req.getRequestDispatcher(PREFIX+jumpPath+SUFFIX).forward(req, resp); // 服务器跳转
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
