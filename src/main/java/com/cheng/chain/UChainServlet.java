package com.cheng.chain;


import com.cheng.servletmvc.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Desc: 区块链相关
 * Author: hp
 * Date: 2017/6/12
 *
 * http://localhost/ServletMVC/chain?method=index&api=repaymentstatus
 *
 */
public class UChainServlet extends BaseServlet {
    private static final String API = "api";
    // json的数据
    private static final String CHAINCONFIG = "/chainConfig.properties";

    /**
     * 请求的接口
     * @param request
     * @param response
     */
    public void index(HttpServletRequest request, HttpServletResponse response) {
        String api = getParameter(request, API);
        String json = getJson(api);
        writerToClient(response, json);
    }

    /**
     * 获取json
     * @param key
     * @return
     */
    private String getJson(String key) {
        InputStream stream = getClass().getResourceAsStream(CHAINCONFIG);
        Properties props = new Properties();
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key, "");
    }

}