package com.kq.webflux.util;

import com.kq.dto.DtoResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * ExceptionUtil
 *
 * @author kq
 * @date 2019-09-17
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    public static DtoResult getMessage(BindingResult bindingResult){

        DtoResult result = new DtoResult();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {

            String message = fieldError.getDefaultMessage();
            String code = fieldError.getCode();
            Object []arguments = fieldError.getArguments();

//            logger.info("code={}  filed={}  exception={}",code,fieldError.getField(),ex.getMessage());

            if("NotNull".equals(code)||"NotEmpty".equals(code)){
                result.setResult(message);
                result.setCode("10820001");
            }else if("Size".equals(code)){
                result.setResult(message);
                result.setCode("10820002");
            }else if("Pattern".equals(code)){
                result.setResult(message);
                result.setCode("10820003");
            }else{
                result.setResult(message);
                result.setCode("10820000");
            }
            break;

        }

        return result;
    }

}
