package com.userlogin.userlogin.dao.api;

import com.userlogin.userlogin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserH2Repository extends IUserRepository, CrudRepository<User, String> {

}
