package com.userlogin.userlogin.controller;

import com.userlogin.userlogin.dto.UserDto;
import com.userlogin.userlogin.entity.User;
import com.userlogin.userlogin.service.user.api.IUserDataConverterService;
import com.userlogin.userlogin.service.user.api.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private IUserService IUserService;

    @Autowired
    private IUserDataConverterService IUserDataConverterService;

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll() {

        try {
            List<User> userList = IUserService.findAll();
            List<UserDto> userDtoList = IUserDataConverterService.getUserDtoList(userList);
            return ResponseEntity.ok(userDtoList);
        }catch (Exception e) {
            logger.error("Error on function 'getAll'");
            logger.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid @RequestBody UserDto userDto) {

        try {
            User user = IUserDataConverterService.getUser(userDto);
            IUserService.save(user);
            return ResponseEntity.ok(null);
        }catch (Exception e) {
            logger.error("Error on function 'getAll'");
            logger.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
