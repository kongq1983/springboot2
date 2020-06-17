package org.springframework.util;

import java.util.Properties;

public class PropertyPlaceholderHelperDemo {

    static PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");

    public static void main1(String[] args) {
//        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper();


        String text = "foo=${foo}";
        Properties props = new Properties();
        props.setProperty("foo", "bar");

        String result = helper.replacePlaceholders(text, props);
        //foo=bar
        System.out.println("result=" + result);

    }

    /**
     * $()
     *
     * @param args
     */
    public static void main2(String[] args) {
//        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper();
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("$(", ")");

        String text = "foo=$(foo)";
        Properties props = new Properties();
        props.setProperty("foo", "bar");

        String result = helper.replacePlaceholders(text, props);
        //foo=bar
        System.out.println("result=" + result);

    }


    /**
     * 递归
     *
     * @param args
     */
    public static void main(String[] args) {

        String text = "foo=${bar}";
        Properties props = new Properties();
        props.setProperty("bar", "${baz}");
        props.setProperty("baz", "bar");

        System.out.println(helper.replacePlaceholders(text, props));

    }


}
