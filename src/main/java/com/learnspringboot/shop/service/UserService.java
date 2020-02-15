package com.learnspringboot.shop.service;

import com.learnspringboot.shop.models.User;
import com.learnspringboot.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:47 PM
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user, long id){
        // Check Error
        User testUser = userRepository.findById(id).get();
        user.setId(id);
        userRepository.save(user);
    }

    public Collection<User> getUsers(){
        return userRepository.findAll();
    }
}
