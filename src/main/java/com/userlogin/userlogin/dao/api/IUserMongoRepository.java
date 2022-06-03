package com.userlogin.userlogin.dao.api;

import com.userlogin.userlogin.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserMongoRepository extends IUserRepository, MongoRepository<User, String> {

}
