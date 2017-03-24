package com.cheng.other.test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/26
 */
public class RedFile {

    public static void main(String[] args) throws IOException {
        redFile();
    }

    public static void redFile() throws IOException {
        File srcFile = new File("E:\\Idea\\ServletMVC\\src\\test\\resources\\sql.txt");
        List<String> contents = Files.readLines(srcFile, Charsets.UTF_8);

        Set<String> sqls = new HashSet<>();
        for (String content : contents) {
            sqls.add(content.trim());
        }
        for (int i=1; i<=sqls.size(); i++) {
            System.out.println("('"+i+"','"+contents.get(i-1)+"','1','9999','9999'),");
        }

        //for (String string : contents) {
        //    System.out.println(string);
        //}
    }

}
