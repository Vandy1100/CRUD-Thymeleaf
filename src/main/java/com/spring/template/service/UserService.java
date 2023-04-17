package com.spring.template.service;

import com.spring.template.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllData();

    void save(User user);
     User get(Integer id) throws UserNotFoundException;
     void delete(Integer id) throws UserNotFoundException, UnsupportedOperationException;
}
