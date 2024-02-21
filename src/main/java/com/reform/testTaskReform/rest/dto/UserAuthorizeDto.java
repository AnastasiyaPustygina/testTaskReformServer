package com.reform.testTaskReform.rest.dto;

import com.reform.testTaskReform.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserAuthorizeDto {
    private final String email;
    private final String password;

    public static UserAuthorizeDto toDto(User user){
        return UserAuthorizeDto.builder().email(user.getEmail()).password(user.getPassword()).build();
    }

    public static User toDomainObject(UserAuthorizeDto user){
        return User.builder().email(user.getEmail()).password(user.getPassword()).build();
    }

}
