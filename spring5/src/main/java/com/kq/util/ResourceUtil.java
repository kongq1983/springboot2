package com.kq.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * ResourceUtil
 *
 * @author kq
 * @date 2019-12-10
 */
public class ResourceUtil {

    public static final String filename = "helloworld";

    public static final String UTF8 = "UTF-8";

    public static void main(String[] args) throws Exception{

        // 获取所有匹配的路径
        Enumeration<URL> eUrl1 =  ResourceUtil.class.getClassLoader().getResources("com/kq");
        while (eUrl1.hasMoreElements()) {
            System.out.println(eUrl1.nextElement());
        }

        // 从classpath
        try(InputStream io = ResourceUtil.class.getResourceAsStream("/"+filename)){
            String content = IOUtils.toString(io,UTF8);
            System.out.println("content=1, read data ="+content);
        }

        try(InputStream io = ResourceUtil.class.getClassLoader().getResourceAsStream(filename)){
            String content = IOUtils.toString(io,UTF8);
            System.out.println("content=1, read data ="+content);
        }

        try(InputStream io = ClassLoader.getSystemResourceAsStream(filename)){
            String content = IOUtils.toString(io,UTF8);
            System.out.println("content=1, read data ="+content);
        }

        java.net.URL url = ResourceUtil.class.getResource("/"+filename);
        System.out.println("url: "+url);

        Enumeration<URL> eUrl =  ResourceUtil.class.getClassLoader().getResources(filename);
        while (eUrl.hasMoreElements()) {
            System.out.println(eUrl.nextElement());
        }



//        try(InputStream io = ResourceUtil.class.getResourceAsStream(filename)){
//            String content = IOUtils.toString(io,UTF8);
//            System.out.println("content=2, read data ="+content);
//        }

    }

}
