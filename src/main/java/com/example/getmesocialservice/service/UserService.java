package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).get();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

   public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUserByName(String name) {
        return userRepository.findAllByName(name);
    }

    /*public User getUser(){
        return userRepository.getUser();
    }


*/





}
