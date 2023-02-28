package com.dh.humanresources.repository;

import com.dh.humanresources.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoUserRepository extends MongoRepository<User,String> {
}


