package com.kq.mytest.other;


import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kq.dto.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@JsonTest
//@ContextConfiguration
//@SpringBootConfiguration

/**
 * https://github.com/json-path/JsonPath
 */
public class MyJsonTests {

    /** mvn test 的时候 会报错  springboot原因
//    @Autowired
    private JacksonTester<Employee> json;


    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Possibly configure the mapper
        JacksonTester.initFields(this, objectMapper);
    }


    @Test
    public void testSerialize() throws Exception {
        Employee e = new Employee();
        e.setId(1l);
        e.setName("king");

        // Assert against a `.json` file in the same package as the test
//        assertThat(this.json.write(details)).isEqualToJson("expected.json");
//        // Or use JSON path based assertions
        assertThat(this.json.write(e)).hasJsonPathStringValue("@.name");
//        assertThat(this.json.write(e)).hasJsonPathStringValue("@.id");
        assertThat(this.json.write(e)).extractingJsonPathStringValue("@.name")
                .isEqualTo("king");
        assertThat(this.json.write(e)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(1);
    }


    */
}
