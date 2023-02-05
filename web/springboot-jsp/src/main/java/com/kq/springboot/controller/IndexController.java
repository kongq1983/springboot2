package com.kq.springboot.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * IndexController
 *
 * @author kq
 * @date 2023-02-05 12:45
 * @since 1.0.0
 */
@Controller
public class IndexController {

//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }

    // http://localhost:10000/index?type=1
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(required = false)Integer type) throws Exception{

        ModelAndView mv = new ModelAndView();
        if(type!=null && type.intValue()==1) {
            mv.addObject("htmlVal",getHtmlVal());
            mv.setViewName("common/empty");
        }else{
            mv.setViewName("index");
        }

        return mv;
    }


    public String getHtmlVal() throws Exception{

        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url("https://www.baidu.com/").build();
        Response rep = client.newCall(req).execute();
        System.out.println("返回码："+rep.code());
        //rep.header("这里写头，可以得到相关值")
        //rep.body().string() 只能被调用一次，在要对返回内容做多次操作时用字符串存一下
        String content = rep.body().string();

        System.out.println("返回内容："+content);

        return content;
    }

}
