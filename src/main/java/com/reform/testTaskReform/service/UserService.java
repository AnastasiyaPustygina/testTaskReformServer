package com.reform.testTaskReform.service;

import com.reform.testTaskReform.domain.Route;
import com.reform.testTaskReform.domain.User;
import com.reform.testTaskReform.rest.dto.RouteDto;
import com.reform.testTaskReform.rest.dto.UserDto;

public interface UserService {

    User getUserByEmailAndPassword(String email, String password);

    User insertUser(User user);

    User updateUser(User user);

    User insertRoute(Route route, double newAvgSpeed, long userId);

    void deleteUserById(long userId);
}
