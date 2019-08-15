package org.springframework.util.unit;

import org.junit.Test;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * LinkedCaseInsensitiveMapTest
 * 不区分大小Map
 * @author kq
 * @date 2019-08-15
 */
public class LinkedCaseInsensitiveMapTest {


    @Test
    public void testMap(){
        Map<String,String> map = new LinkedCaseInsensitiveMap();
        String value = "king";

        map.put("NaME",value);

        String v = map.get("NAme");

        assertEquals(v,value);

        v = map.get("name");

        assertEquals(v,value);

    }


}
