package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.rest.dto.RouteDto;
import com.reform.testTaskReform.rest.dto.UserAuthorizeDto;
import com.reform.testTaskReform.rest.dto.UserDto;
import com.reform.testTaskReform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

    private final UserService userService;
    @Override
    @PostMapping("/register/user")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return UserDto.toDto(userService.insertUser(UserDto.toDomainObject(userDto)));
    }

    @Override
    @GetMapping("/authorize/user")
    public UserDto authorizeUser(@RequestBody UserAuthorizeDto userAuthorizeDto) {
        return UserDto.toDto(userService.getUserByEmailAndPassword(userAuthorizeDto.getEmail(), userAuthorizeDto.getPassword()));
    }

    @Override
    @PutMapping("/update/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return UserDto.toDto(userService.updateUser(UserDto.toDomainObject(userDto)));
    }

    @Override
    @PutMapping("/update/user/route")
    public UserDto insertRoute(RouteDto routeDto, double avgSpeed, long userId) {
        return UserDto.toDto(userService.insertRoute(RouteDto.toDomainObject(routeDto), avgSpeed, userId));
    }
}
