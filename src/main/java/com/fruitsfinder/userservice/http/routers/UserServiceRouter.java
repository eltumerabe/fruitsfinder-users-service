package com.fruitsfinder.userservice.http.routers;

import com.fruitsfinder.userservice.http.handlers.UserServiceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserServiceRouter {

    @Bean
    public RouterFunction<ServerResponse> getEmployeeByIdRoute(final UserServiceHandler userServiceHandler) {
        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.TEXT_PLAIN)),userServiceHandler::welcome);
    }


}
