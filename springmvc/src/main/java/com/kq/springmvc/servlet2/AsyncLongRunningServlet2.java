package com.kq.springmvc.servlet2;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/** 非阻塞
 * @author kq
 * @date 2020-09-15 19:13
 * @since 2020-0630
 */
@WebServlet(urlPatterns = "/AsyncLongRunningServlet2", asyncSupported = true)
public class AsyncLongRunningServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if(type!=null) {
            response.setContentType("application/json;charset=UTF-8");
        }else {
            response.setContentType("text/html;charset=UTF-8");
        }

        AsyncContext actx = request.startAsync();//通过request获得AsyncContent对象

        actx.setTimeout(30*3000);//设置异步调用超时时长

        ServletInputStream in = request.getInputStream();
        //异步读取（实现了非阻塞式读取）
        in.setReadListener(new MyReadListener(in,actx));
        //直接输出到页面的内容(不等异步完成就直接给页面)
        PrintWriter out = response.getWriter();
        out.println("<h1>直接返回页面，不等异步处理结果了</h1>");
        out.flush();
    }

}