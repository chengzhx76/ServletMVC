package com.cheng.servletmvc;

import com.alibaba.fastjson.JSON;
import com.cheng.mode.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/25
 */
public class AjaxReload extends BaseServlet {
    public void reloadData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        List<User> users = new ArrayList<>();
        if (new Random().nextInt(9)/3==0) {
            User user = new User();
            user.setUsername("chengzhx"+new Random().nextInt(99));
            user.setSex(new Random().nextInt(9)/2==0 ? "男" : "女");
            user.setBirthday(sdf.format(new Date()));
            users.add(user);
            if (new Random().nextInt(9)/2==0) {
                user = new User();
                user.setUsername("chengzhx" + new Random().nextInt(99));
                user.setSex(new Random().nextInt(9) / 2 == 0 ? "男" : "女");
                user.setBirthday(sdf.format(new Date()));
                users.add(user);
            }
        }

        String data = JSON.toJSONString(users);
        System.out.println("===> "+data);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer;
        writer = response.getWriter();
        writer.write(data);
        writer.flush();
    }

    public String reload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=====> reload");

        return "reload";
    }
}
