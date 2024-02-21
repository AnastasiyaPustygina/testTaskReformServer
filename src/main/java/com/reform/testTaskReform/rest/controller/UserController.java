package com.reform.testTaskReform.rest.controller;

import com.reform.testTaskReform.rest.dto.RouteDto;
import com.reform.testTaskReform.rest.dto.UserAuthorizeDto;
import com.reform.testTaskReform.rest.dto.UserDto;

public interface UserController {

    UserDto registerUser(UserDto userDto);

    UserDto authorizeUser(UserAuthorizeDto userAuthorizeDto);

    UserDto updateUser(UserDto userDto);

    UserDto insertRoute(RouteDto routeDto, double avgSpeed, long userId);

}
