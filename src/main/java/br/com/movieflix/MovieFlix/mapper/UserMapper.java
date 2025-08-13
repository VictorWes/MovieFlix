package br.com.movieflix.MovieFlix.mapper;

import br.com.movieflix.MovieFlix.Controller.request.UserRequest;
import br.com.movieflix.MovieFlix.Controller.response.UserResponse;
import br.com.movieflix.MovieFlix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest){

        return User.builder()
                .name(userRequest.name())
                .password(userRequest.password())
                .email(userRequest.email())
                .build();
    }

    public static UserResponse toResponse(User userResponse){

        return UserResponse.builder()
                .id(userResponse.getId())
                .name(userResponse.getName())
                .email(userResponse.getEmail())
                .build();

    }

}
