package com.cheng.test;

import com.alibaba.fastjson.JSON;
import com.cheng.mode.User;

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
public class TestMain {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUsername("chengzhx"+new Random().nextInt(99));
        user.setSex(new Random().nextInt(9)/2==0 ? "男" : "女");
        user.setBirthday(sdf.format(new Date()));
        users.add(user);

        user = new User();
        user.setUsername("chengzhx"+new Random().nextInt(99));
        user.setSex(new Random().nextInt(9)/2==0 ? "男" : "女");
        user.setBirthday(sdf.format(new Date()));
        users.add(user);

        String data = "";
        if (new Random().nextInt(9)/2==0) {
            data = JSON.toJSONString(user);
        } else {
            data = JSON.toJSONString(users);
        }
        System.out.println("===> "+data);
    }
}
