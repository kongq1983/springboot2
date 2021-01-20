package com.kq.es.document;

import com.kq.service.BaseApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kq
 * @date 2021-01-20 17:01
 * @since 2020-0630
 */
public class QueryDocumentTest extends BaseApplicationTest {

    @Autowired
    private QueryDocument queryDocument;


    @Test
    public void search() throws Exception{
        queryDocument.search();
    }

}
