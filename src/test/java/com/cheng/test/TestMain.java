package com.cheng.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/25
 */
public class TestMain {
    public static void main(String[] args) {

        /*SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
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
        System.out.println("===> "+data);*/
    }

    @Test
    public void test01() {
        Map<String, Object> json = new HashMap<>();

        Map<String, Object> data = new HashMap<>();
        data.put("transaction_date", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        data.put("transaction_id",  RandomStringUtils.randomAlphanumeric(10));

        Map<String, Object> history = new HashMap<>();
        history.put("order_status", RandomUtils.nextInt(0, 2));
        history.put("txid", RandomStringUtils.randomAlphanumeric(10));
        data.put("order_status_history", history);

        json.put("data", data);
        json.put("sign_type", "");
        json.put("sign_data", "");
        json.put("code", 200);
        json.put("success", true);
        json.put("msg", "请求成功");

        System.out.println(JSON.toJSONString(json));
    }

}
