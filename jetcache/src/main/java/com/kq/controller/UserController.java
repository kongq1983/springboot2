package com.kq.controller;


import com.kq.dto.DtoResult;
import com.kq.dto.User;
import com.kq.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public DtoResult add(@RequestBody User e) {

        log.debug("添加员工接收参数={}",e);

        DtoResult result = new DtoResult();
        result.setResult(e);
        return result;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public DtoResult add(@PathVariable("id") Long id) {

        log.debug("用户ID接收参数={}",id);

        DtoResult result = new DtoResult();
        result.setResult(userService.getUserById(id));
        return result;
    }


    @RequestMapping(value="/update",method = RequestMethod.POST)
    public DtoResult update(@RequestBody User u) {

        log.debug("修改员工接收参数={}",u);

        userService.update(u);

        DtoResult result = new DtoResult();
        result.setResult(u);
        return result;
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public DtoResult delete(@PathVariable("id") Long id) {

        log.debug("删除ID接收参数={}",id);
        userService.delete(id);
        DtoResult result = new DtoResult();
        return result;
    }

}
