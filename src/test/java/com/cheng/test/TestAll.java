package com.cheng.test;

import org.junit.Test;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/7/24
 */
public class TestAll {

    @Test
    public void mopao() {
        System.out.println();
        int[] arr = {9, 7, 5, 3, 1};
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                System.out.print(arr[i]+" ");
            }

            //System.out.print(arr[i]);
            //System.out.print("-");
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(dg(4)); //第三十个
        sub();
    }

    public static int dg(int count){
        if(count==2 || count== 1){
            return 1;
        }else {
            int i = dg(count-1);
            int j = dg(count-2);
            return i+j;
        }
    }


    private static void sub() {
        String str = "A0002864_201702241717421487927862468_dbtestfrms_2";
        System.out.println(str.indexOf("_"));
        String data = str.substring(str.indexOf("_", str.indexOf("_")+1)+1, str.lastIndexOf("_"));

        System.out.println(data);

    }




}
