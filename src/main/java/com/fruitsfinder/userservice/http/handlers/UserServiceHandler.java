package com.fruitsfinder.userservice.http.handlers;

import com.fruitsfinder.userservice.domain.dto.request.CreateUserRequestDto;
import com.fruitsfinder.userservice.domain.dto.response.CreateUserResponsetDto;
import com.fruitsfinder.userservice.processor.UserProcessor;
import com.fruitsfinder.userservice.util.RequestBodySerializerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserServiceHandler {

    private final UserProcessor userProcessor;
    private final RequestBodySerializerUtil requestBodySerializerUtil;

    public Mono<ServerResponse> createUser(final ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userProcessor.createUser(requestBodySerializerUtil.bodyToMono(serverRequest, CreateUserRequestDto.class)),CreateUserResponsetDto.class);
    }
}
