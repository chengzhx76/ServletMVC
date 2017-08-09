package com.cheng.other.test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Desc:
 * Author: hp
 * Date: 2017/6/27
 */
public class TestJson {


    public static void main(String[] args) throws IOException {
        test01();
    }


    private static void test01() throws IOException {
        File srcFile = new File("E:\\Idea\\ServletMVC\\src\\test\\resources\\json.txt");
        List<String> contents = Files.readLines(srcFile, Charsets.UTF_8);
        String data = contents.get(0);
        Map<String, String> map = JSON.parseObject(data, Map.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

            if ("retmsg".equals(entry.getKey())) {
                List<String> list = JSON.parseArray(entry.getValue(), String.class);
                for (String str : list) {
                    Map<String, Object> map2 = JSON.parseObject(str, Map.class);
                    for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                        System.out.println("key2= " + entry2.getKey() + " and value2= " + entry2.getValue());
                    }
                }

            }

        }
    }


}
