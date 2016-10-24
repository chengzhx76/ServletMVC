package com.cheng.servletmvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Desc: 发送消息处理
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
    public String updata(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("===========succcess========ss==");


            request.setCharacterEncoding("utf-8");
            //迭代Collection中所有Part对象
            for (Part part : request.getParts()) {
                //只处理上传文件区段
                if (part.getName().startsWith("file")) {
                    String fileName = getFileName(part);
                    //part.write(fileName);

                    writeTo(fileName, part);
                }
            }


        return "succcess";
    }

    private String getFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        header.lastIndexOf("\"");
        return fileName;
    }

    //存储文件
    private void writeTo(String fileName, Part part) throws IOException, FileNotFoundException {
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream("c:/" + fileName);
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
    }
}
