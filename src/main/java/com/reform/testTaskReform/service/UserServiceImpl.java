package com.reform.testTaskReform.service;

import com.reform.testTaskReform.domain.Route;
import com.reform.testTaskReform.domain.User;
import com.reform.testTaskReform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordService passwordService;

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User insertUser(User user) {

        // Среднюю скорость лучше вынести в файл констант

        return userRepository.save(
                User.builder().id(user.getId()).name(user.getName()).email(user.getEmail())
                        .password(passwordService.encodePassword(user.getPassword()))
                        .avgSpeed(5).routes(Collections.emptyList()).build()
        );
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User insertRoute(Route route, double newAvgSpeed, long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                "User with id = " + userId + " was not found"));
        List<Route> routes = user.getRoutes();
        routes.add(route);
        user.setRoutes(routes);
        return userRepository.save(User.builder().id(user.getId()).name(user.getName()).email(user.getEmail())
                .password(user.getPassword())
                .avgSpeed(calculateUserAvgSpeed(newAvgSpeed, user)).routes(routes).build());
    }

    private double calculateUserAvgSpeed(double newSpeed, User user) {
        double previousAvgSpeed = user.getAvgSpeed();
        List<Route> routes = user.getRoutes();
        int countOfRoutes = routes.size();
        double newAvgSpeed = (previousAvgSpeed * countOfRoutes + newSpeed) / (countOfRoutes + 1);
        return newAvgSpeed;
    }

    @Override
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }
}
