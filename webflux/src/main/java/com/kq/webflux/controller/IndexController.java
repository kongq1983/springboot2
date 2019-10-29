package com.kq.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * IndexController
 * @author kq
 * @date 2019-09-17
 */

@Component
public class IndexController {

    public Mono<ServerResponse> welcome(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("welcome to webflux!"));
    }


    public Mono<ServerResponse> requestParam(ServerRequest request){
        Mono<String> mono =  Mono.justOrEmpty(request.queryParam("data"))
                .defaultIfEmpty("empty")
                .map(it -> it.concat("! from server webflux!"));
        return ServerResponse.ok().body(mono,String.class);
    }

}
