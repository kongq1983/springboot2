package com.kq.webflux.router;

import com.kq.webflux.controller.IndexController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Router
 * @author kq
 * @date 2019-09-17
 */
@Configuration
public class Router {

    public static final String APPLICATION_JSON = "application/json";

    @Autowired
    private IndexController indexController;

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(RequestPredicates.GET("/welcome")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        indexController::welcome)
                .andRoute(RequestPredicates.GET("/requestParam")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), indexController::requestParam);
    }

}
