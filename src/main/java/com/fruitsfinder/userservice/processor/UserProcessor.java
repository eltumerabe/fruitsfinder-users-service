package com.fruitsfinder.userservice.processor;

import com.fruitsfinder.userservice.domain.dto.request.CreateUserRequestDto;
import com.fruitsfinder.userservice.domain.dto.response.CreateUserResponsetDto;
import com.fruitsfinder.userservice.domain.entity.UserDocument;
import com.fruitsfinder.userservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserProcessor {
    private final UserRepository userRepository;

    public Mono<CreateUserResponsetDto> createUser(final Mono<CreateUserRequestDto> createUserRequestDto) {
        return createUserRequestDto
                .map(createUserRequestDto1 -> UserDocument
                        .builder()
                        .firstName(createUserRequestDto1.getFirstName())
                        .lastName(createUserRequestDto1.getLastName())
                        .build())
                .flatMap(userDocument -> userRepository.save(userDocument)
                        .onErrorResume(throwable -> {
                            log.error("Error while saving the data to mongoDB ",throwable);
                            // TODO: Exception to be thrown
                            return null;
                        }))
                .map(userDocument -> CreateUserResponsetDto
                        .builder()
                        .id(userDocument.getId())
                        .firstName(userDocument.getFirstName())
                        .lastName(userDocument.getLastName())
                        .build()).onErrorResume(throwable -> Mono.just(CreateUserResponsetDto
                                .builder()
                                .build()));
    }
}

