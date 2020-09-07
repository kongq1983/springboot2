package com.kq.util;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * FindClassUtil
 * 读取所有匹配的class
 * @author kq
 * @date 2019-12-10
 */
public class FindClassUtil {

    public static ClassLoader getClassLoader() {
        return FindClassUtil.class.getClassLoader();
    }

    public static Set<File> getFilePath(String basePackage) throws Exception {

        Set<File> filePaths = new HashSet<>();

        // 获取所有匹配的路径
        Enumeration<URL> eUrl1 = getClassLoader().getResources(basePackage);
        while (eUrl1.hasMoreElements()) {
            URL url = eUrl1.nextElement();
            String filePath = url.getPath();
            String file = url.getFile();
            filePaths.add(new File(filePath));
            System.out.println("file="+", path="+filePath);
        }

        return filePaths;
    }

    protected static File[] listDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            return new File[0];
        }
        Arrays.sort(files, Comparator.comparing(File::getName));
        return files;
    }

    protected static void doRetrieveMatchingFiles(String fullPattern, File dir, Set<File> result) throws IOException {

        for (File content : listDirectory(dir)) {
            String currPath = StringUtils.replace(content.getAbsolutePath(), File.separator, "/");
            if (content.isDirectory() ) {
                doRetrieveMatchingFiles(fullPattern, content, result);
            }
            System.out.println("currPath="+currPath);
            result.add(content);
        }
    }


    public static void main(String[] args) throws Exception{

        Set<File>  files = getFilePath("com/kq");

        Set<File> classFileSet = new LinkedHashSet<>();

        for(File file : files) {
            doRetrieveMatchingFiles("com.kq",file,classFileSet);
            System.out.println(file.getAbsolutePath());
        }


        classFileSet.forEach(System.out::println);

        // see PathMatchingResourcePatternResolver. doRetrieveMatchingFiles
    }

}
