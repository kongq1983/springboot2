package org.springframework.core;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2020-09-01 17:46
 * @since 2020-0630
 */
public class ResolvableTypeDemo {

    HashMap<String,Integer> map = new HashMap<>();
    ArrayList<AtomicInteger> list = new ArrayList<>();
    List<? extends Number> numbers = new ArrayList<>();
    List<? super Number> superList = new ArrayList<>();
    List<AtomicInteger[]> array = new ArrayList<>();
    Set<AtomicLong> set = new HashSet<>();
    String name;


    public static void main(String[] args) throws Exception{

        ResolvableType t = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField("map"));
        System.out.println("t="+t);
        System.out.println("getSuperType="+t.getSuperType());
        System.out.println("asMap="+t.asMap());
        System.out.println("t.getRawClass()="+t.getRawClass());
        System.out.println("t.getGeneric(0).getRawClass()="+t.getGeneric(0).getRawClass()); // RawClass  第0个
        System.out.println("t.getGeneric(1).getRawClass()="+t.getGeneric(1).getRawClass()); // RawClass  第1个
        System.out.println("t.getGeneric(0).getSuperType()="+t.getGeneric(0).getSuperType()); // 第0个泛型的父类  第0个
        System.out.println("t.getGeneric(1).getSuperType()="+t.getGeneric(1).getSuperType()); // 第1个泛型的父类  第1个
        System.out.println("t.getGeneric(0).resolve()="+t.getGeneric(0).resolve()); // 泛型  第0个
        System.out.println("t.getGeneric(1).resolve()="+t.getGeneric(1).resolve()); // 泛型  第1个
    }

    public static void main1(String[] args) throws Exception{
        String filed = "map";
//        String filed = "list";
//        String filed = "set";
//        String filed = "array";
//        String filed = "numbers";
//        String filed = "superList";
        ResolvableType t = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField(filed));
        System.out.println("t="+t);
        System.out.println("getSuperType="+t.getSuperType());
        System.out.println("asMap="+t.asMap());
        System.out.println("t.getRawClass()="+t.getRawClass());
        System.out.println("t.getGeneric(0).getRawClass()="+t.getGeneric(0).getRawClass()); // 泛型  第0个
        System.out.println("t.getGeneric(0).getSuperType()="+t.getGeneric(0).getSuperType()); // 泛型  第0个
        System.out.println("t.getGeneric(1).getSuperType()="+t.getGeneric(1).getSuperType()); // 泛型  第1个
        System.out.println("t.getGeneric(0).resolve()="+t.getGeneric(0).resolve()); // 泛型  第0个
        System.out.println("t.getGeneric(1).resolve()="+t.getGeneric(1).resolve()); // 泛型  第1个
    }

    public static void mainMap(String[] args) throws Exception{

        ResolvableType t = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField("map"));
        System.out.println("t="+t);
        System.out.println("getSuperType="+t.getSuperType());
        System.out.println("asMap="+t.asMap());
        System.out.println("t.getRawClass()="+t.getRawClass());
        System.out.println("t.getGeneric(0).resolve()="+t.getGeneric(0).resolve()); // 泛型  第0个
        System.out.println("t.getGeneric(1).resolve()="+t.getGeneric(1).resolve()); // 泛型  第1个
        System.out.println("t.getGeneric(1)="+t.getGeneric(1)); // 泛型  第1个
        System.out.println("t.resolveGeneric(1, 0)="+t.resolveGeneric(1, 0)); // 泛型  第1个

        for(ResolvableType tt : t.getInterfaces()) {
            System.out.println("t.getInterfaces=" + tt); //
        }

        ResolvableType string = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField("name"));
        System.out.println("string="+string);

    }

}
