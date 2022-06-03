package com.userlogin.userlogin.service.user;

import com.userlogin.userlogin.dao.api.IUserMongoRepository;
import com.userlogin.userlogin.entity.User;
import com.userlogin.userlogin.service.user.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMongoRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setCreationTime(new Date());
        return userRepository.save(user);
    }


}
