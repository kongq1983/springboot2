package com.kq.springmvc.controller.hbweixin;

import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2021-02-04 10:50
 * @since 2020-0630
 */
@RestController
@Slf4j
@RequestMapping(value="/hbweixin/slwx/page/wsdc")
public class HbWeixinController {


    @RequestMapping(value="/addSaleOrder",method = {RequestMethod.GET,RequestMethod.POST})
    public DtoResult addSaleOrder(@RequestParam(name="timeout",required=false) Long timeout) {

        log.debug("addSaleOrder接收参数={}",timeout);

        if(timeout==null) {
            timeout = 8L;
        }

        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
            log.error("addSaleOrder error",e);
        }

        DtoResult result = new DtoResult();
        result.setResult(timeout);
        return result;
    }

    @RequestMapping(value="/paySaleOrder",method = {RequestMethod.GET,RequestMethod.POST})
    public DtoResult paySaleOrder(@RequestParam(name="timeout",required=false) Long timeout) {

        log.debug("paySaleOrderr接收参数={}",timeout);

        if(timeout==null) {
            timeout = 6L;
        }

        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
            log.error("paySaleOrder error",e);
        }

        DtoResult result = new DtoResult();
        result.setResult(timeout);
        return result;
    }

    @RequestMapping(value="/addOrderCart",method = {RequestMethod.GET,RequestMethod.POST})
    public DtoResult addOrderCart(@RequestParam(name="timeout",required=false) Long timeout) {

        log.debug("addOrderCart={}",timeout);

        if(timeout==null) {
            timeout = 1L;
        }

        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
            log.error("addOrderCart error",e);
        }

        DtoResult result = new DtoResult();
        result.setResult(timeout);
        return result;
    }


}
