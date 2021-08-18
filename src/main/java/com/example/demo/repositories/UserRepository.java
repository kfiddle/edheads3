package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
//@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
