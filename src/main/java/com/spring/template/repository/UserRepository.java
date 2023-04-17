package com.spring.template.repository;

import com.spring.template.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
