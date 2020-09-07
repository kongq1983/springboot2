package com.kq.springmvc.controller;

import com.kq.dto.DtoResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class TimeoutController {

    /**
     * @param id
     * @return
     */
    @RequestMapping(value="/timeout/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public DtoResult query(String id) throws Exception{

        TimeUnit.SECONDS.sleep(65);
        DtoResult result = new DtoResult();
        result.setResult(id);
        return result;
    }

}
