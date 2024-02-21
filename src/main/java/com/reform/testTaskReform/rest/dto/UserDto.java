package com.reform.testTaskReform.rest.dto;

import com.reform.testTaskReform.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {

    private final long id;
    private final String name;
    private final String email;
    private final String password;
    private final double avgSpeed;
    private final List<RouteDto> routes;

    public static UserDto toDto(User user){
        return UserDto.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).password(user.getPassword())
                .avgSpeed(user.getAvgSpeed()).routes(user.getRoutes().stream().map(RouteDto::toDto).toList()).build();
    }

    public static User toDomainObject(UserDto user){
        return User.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).password(user.getPassword())
                .avgSpeed(user.getAvgSpeed()).routes(user.getRoutes().stream().map(RouteDto::toDomainObject).toList()).build();
    }
}
