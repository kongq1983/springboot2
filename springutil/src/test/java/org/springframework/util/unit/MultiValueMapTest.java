package org.springframework.util.unit;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.junit.Assert.*;

/**
 * MultiValueMapTest
 *
 * @author kq
 * @date 2019-08-15
 */
public class MultiValueMapTest {


    @Test
    public void testMultiValueMap(){

        MultiValueMap<String,String> map = new LinkedMultiValueMap();
        String key ="zhejiang";

        map.add(key,"hangzhou");
        map.add(key,"ningbo");
        map.add(key,"zhoushan");

        String firstValue = map.getFirst(key);

        assertEquals("hangzhou",firstValue);

        List<String> values = map.get(key);

        assertEquals(values, Lists.newArrayList("hangzhou","ningbo","zhoushan"));

        //key 不存在 则取默认的
        values = map.getOrDefault("shanghai",Lists.newArrayList("pudong"));

        assertEquals(values, Lists.newArrayList("pudong"));

    }


}
