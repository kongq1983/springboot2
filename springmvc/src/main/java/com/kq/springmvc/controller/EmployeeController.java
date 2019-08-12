package com.kq.springmvc.controller;

import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value="/employee")
public class EmployeeController {

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public DtoResult add(@RequestBody Employee e) {

        log.debug("添加员工接收参数={}",e);

        DtoResult result = new DtoResult();
        result.setResult(e);
        return result;
    }


    /**
     * 不是通过json
     * @param e
     * @param age
     * @param id
     * @return
     */
    @RequestMapping(value="/update/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public DtoResult update(Employee e, @RequestParam(name="age",required=false) Integer age, @PathVariable("id")String id) {

        log.debug("修改员工接收参数={}",e);
        log.debug("修改员工 id={},age={}",id,age);

        DtoResult result = new DtoResult();
        result.setResult(e);
        return result;
    }


}
