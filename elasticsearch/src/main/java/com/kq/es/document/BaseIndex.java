package com.kq.es.document;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseIndex
 *
 * @author kq
 * @date 2019-10-22
 */
public class BaseIndex {

    public static final String DOC = "_doc";

    @Autowired
    protected RestHighLevelClient restHighLevelClient;

}
