package com.kq.webflux.controller;

import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

/**
 * ValidateController
 *
 * @author kq
 * @date 2019-09-17
 */
@Slf4j
@Component
public class ValidateController {

    @PostMapping("/validate-mono")
    public Mono<String> formValidate(@Validated Mono<Employee> user) {
//        return user
//                .map(u -> "Hello " + u.getName())
//                .onErrorResume(WebExchangeBindException.class, e -> Mono.just(bindingResult2String(e.getBindingResult())));

        return null;
    }

}
