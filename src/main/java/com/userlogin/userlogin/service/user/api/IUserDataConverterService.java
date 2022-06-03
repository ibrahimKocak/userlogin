package com.userlogin.userlogin.service.user.api;

import com.userlogin.userlogin.dto.UserDto;
import com.userlogin.userlogin.entity.User;

import java.text.ParseException;
import java.util.List;

public interface IUserDataConverterService {

    User getUser(UserDto userDto) throws ParseException;
    UserDto getUserDto(User user);
    List<User> getUserList(List<UserDto> userDtoList);
    List<UserDto> getUserDtoList(List<User> userList);

}
