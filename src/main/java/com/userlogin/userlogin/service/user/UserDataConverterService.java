package com.userlogin.userlogin.service.user;

import com.userlogin.userlogin.dto.UserDto;
import com.userlogin.userlogin.entity.User;
import com.userlogin.userlogin.service.user.api.IUserDataConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDataConverterService implements IUserDataConverterService {

    @Autowired
    private DateDataConverterService dateDataConverterService;

    @Override
    public User getUser(UserDto userDto) throws ParseException {
        return User.builder()
                   .id(userDto.getId())
                   .name(userDto.getName())
                   .birthday(dateDataConverterService.getDate(userDto.getBirthday(), "dd.MM.yyyy"))
                   .accountType(userDto.getAccountType())
                   .creationTime(dateDataConverterService.getDate(userDto.getCreationTime(), "dd.MM.yyyy HH:mm"))
                   .lastUpdateTime(dateDataConverterService.getDate(userDto.getLastUpdateTime(), "dd.MM.yyyy HH:mm"))
                   .build();
    }

    @Override
    public UserDto getUserDto(User user) {
        return UserDto.builder()
                      .id(user.getId())
                      .name(user.getName())
                      .birthday(dateDataConverterService.getString(user.getBirthday(), "dd.MM.yyyy"))
                      .accountType(user.getAccountType())
                      .creationTime(dateDataConverterService.getString(user.getCreationTime(), "dd.MM.yyyy HH:mm"))
                      .lastUpdateTime(dateDataConverterService.getString(user.getLastUpdateTime(), "dd.MM.yyyy HH:mm"))
                      .build();
    }

    @Override
    public List<User> getUserList(List<UserDto> userDtoList) {
        return userDtoList.stream()
                          .map(userDto -> {
                              try {
                                  return getUser(userDto);
                              } catch (ParseException e) {
                                  throw new RuntimeException(e);
                              }
                          })
                          .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUserDtoList(List<User> userList) {
        return userList.stream()
                       .map(this::getUserDto)
                       .collect(Collectors.toList());
    }

}
