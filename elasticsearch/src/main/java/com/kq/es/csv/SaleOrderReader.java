package com.kq.es.csv;

import com.kq.es.entity.SaleOrder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author kq
 * @date 2021-01-19 19:18
 * @since 2020-0630
 */
public class SaleOrderReader {

    public static List<SaleOrder> getSaleOrderList(String fileName) throws IOException {
//        InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "GBK");//注意此处的编码格式，我之前遇到了用utf-8读取出来全是null的问题
        InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "utf-8");//注意此处的编码格式，我之前遇到了用utf-8读取出来全是null的问题
        HeaderColumnNameMappingStrategy<SaleOrder> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
        mappingStrategy.setType(SaleOrder.class);
        CsvToBean<SaleOrder> build = new CsvToBeanBuilder<SaleOrder>(is)
                .withMappingStrategy(mappingStrategy)
                .withFilter(new MyCsvFilter()) //上面建好的过滤器
                .withSeparator(',')  //逗号分隔符文件当然使用,分隔，当然也有例外
//                .withSkipLines(1)	//意思是跳过前面几行后再读取
                .withIgnoreQuotations(true)
                .build();
        List<SaleOrder> billList = build.parse();
        return billList;
    }

    public static List<SaleOrder> getSaleOrderList() throws IOException {
        List<SaleOrder> list = getSaleOrderList("D:\\data\\saleorder.csv");
//        List<SaleOrder> list = getSaleOrderList("D:\\data\\test.csv");
        return list;
    }

    public static void main(String[] args) throws Exception{
//        List<SaleOrder> list = getSaleOrderList("D:\\data\\saleorder.csv");
        List<SaleOrder> list = getSaleOrderList("D:\\data\\test.csv");

        int index = 0;
        for(SaleOrder saleOrder : list) {
            if(index<10){
                System.out.println(saleOrder);
            }
            index++;
        }

    }



}
