package com.fruitsfinder.userservice.domain.repository;

import com.fruitsfinder.userservice.domain.entity.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserDocument,String> {
    Mono<UserDocument> findById(String id);
}
