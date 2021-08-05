package com.kq.mybatis.mapper;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * @date 2021-08-03 9:49
 * @since 2020-0630
 */
public class ExpressionEvaluatorTest {

    public static void main(String[] args) {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

        User user = new User();
        User user1 = new User();
        user.setUser(user1);
        user1.setTenantId("one");


        boolean result = expressionEvaluator.evaluateBoolean("user.tenantId !=null",user);

        System.out.println("result="+result);

    }

    static class User {

        private User user;

        private String tenantId;

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

}
