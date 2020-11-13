package com.kq.batch.generateName;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 如果报空异常，把xing和name1的文件复制到当前class目录下
 * @author kq
 * @date 2020-11-11 13:24
 * @since 2020-0630
 */
public class NameGenerateUtil {

    public static List<String> getFirstNames() {
        return getValues("xing");
    }

    public static List<String> getLastNames() {
        return getValues("name1");
    }


    private static List<String> getValues(String filename) {

        try (
                Stream<String> stream = Files.lines(Paths.get(NameGenerateUtil.class.getResource(filename).toURI()));
        ){

            Function<String, String[]> splitStr = (line) -> {

                if(line==null||line.trim().length()==0) {
                    return new String[0];
                }
                String[] strs = new String[line.length()];
                line = line.trim();
                for(int i=0;i<line.length();i++) {
                    line = line.replaceAll(" ","");
                    if(i<line.length()-1) {
                        strs[i] = line.substring(i, i + 1);
                    }
                }

                return strs;
            };

            Predicate<String> predicate = p-> {
                if(p!=null && p.matches("[^,，。. ]{1}")) {
                    return true;
                }
                return false;
            };

//            stream.flatMap(line -> Stream)
            // 拆成单个字，然后过滤特殊符号
            List<String> list = stream.flatMap(line -> Arrays.stream(splitStr.apply(line))).filter(s-> predicate.test(s)).distinct().collect(Collectors.toList());

            return list;

        }catch (Exception e){
            e.printStackTrace();
        }

        return Collections.emptyList();

    }


    public static void main(String[] args) {
//        getFirstNames().stream().forEach(System.out::println);
        getLastNames().stream().forEach(System.out::println);
    }

}
