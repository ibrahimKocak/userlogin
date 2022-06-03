package com.userlogin.userlogin.dao.api;

import com.userlogin.userlogin.constant.AccountTypeEnum;
import com.userlogin.userlogin.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {

    List<User> findByName(String name);

    List<User> findBySurname(String surname);

    List<User> findByAccountType(AccountTypeEnum accountType);
}
