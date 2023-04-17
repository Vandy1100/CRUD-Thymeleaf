package com.spring.template.service;

import com.spring.template.repository.UserRepository;
import com.spring.template.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllData() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(Integer id) throws UserNotFoundException {
       Optional<User> result= userRepository.findById(id);
       if(result.isPresent()){
           return result.get();
       }
       throw  new UserNotFoundException("Could Not Find Any Users with" + id);
    }

    @Override
    public void delete(Integer id) {
            userRepository.deleteById(id);
//            throw new UnsupportedOperationException("Could Not Find Any Users with" + id);
    }
}
