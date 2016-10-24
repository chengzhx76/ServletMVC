package com.cheng.servletmvc.test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/5/3
 */
public class UrlTest {

    public static void main(String[] args) {
        String refer = "http://webmagic.io/docs/zh/posts/ch4-basic-page-processor/pageprocessor.html";
        String url = "http://webmagic.io/docs/zh/posts/ch4-basic-page-processor/pageprocessor.html";
        URL base;
        //try {
            try {
                base = new URL(refer);
                System.out.println(base.getPath());
                System.out.println(base.toExternalForm());
            } catch (MalformedURLException e) {
                System.out.println("--------ddd----");
                //URL abs = new URL(refer);
                //
                //System.out.println(abs.toExternalForm());
            }


        //} catch (MalformedURLException e) {
        //    System.out.println("------------");
        //}

    }

}
