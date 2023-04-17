package com.spring.template;

import com.spring.template.repository.UserRepository;
import com.spring.template.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserDepositoryTest {
    @Autowired
    private UserRepository repository;
    @Test
    public void testAddNew(){
        User user= new User();
        user.setFname("san");
        user.setLname("boy");
        user.setEmail("Dara@gmail.com");
        user.setPwd("123456");
        repository.save(user);
        System.out.println("add success");
    }
    @Test
    public void testListAll(){
       Iterable<User> users= repository.findAll();
       for(User user:users){
           System.out.println(user);
       }
    }
    @Test
    public void testUpdate(){
        Integer userId=2;
        Optional<User> optionalUser = repository.findById(userId);
        User user= optionalUser.get();
        user.setPwd("vv123");
        user.setEmail("haka@gmail.com");
        user.setLname("haka");
        user.setFname("som");
        repository.save(user);
    }
    @Test
    public void testGet(){
        Integer id=2;
        Optional<User> optionalUser = repository.findById(id);
        System.out.println(optionalUser.get());
    }
    @Test
    public void testDelete(){
        Integer userId=1;
        repository.deleteById(userId);
    }
}
