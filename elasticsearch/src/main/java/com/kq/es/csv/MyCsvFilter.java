package com.kq.es.csv;

/**
 * @author kq
 * @date 2021-01-19 19:17
 * @since 2020-0630
 */
import com.opencsv.bean.CsvToBeanFilter;

public class MyCsvFilter implements CsvToBeanFilter {
    @Override
    public boolean allowLine(String[] line) {
        if (line[0].startsWith("#")) {
            return false;
        }
        return true;
    }
}