package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();
    User user = new User("Het","Canada",25,"https://helpx.adobe.com/photoshop/using/convert-color-image-black-white.html" );


    public User getUser(){
        return user;
    }

    public User saveUser(User user) {
        user.setUserId(userList.size()+1);
        userList.add(user);
        return user;

    }

    public List<User> getAllUsers(){
       // System.out.println(userList);
        return userList;
    }

    public User getUserById(@PathVariable("userId") int userId){
        for(User user:userList){
            if(user.getUserId()==userId){
                return user;
            }
        }
        return null;
    }


    public User updateUser(int userId,User user) {
        for(User u:userList) {
            if (user.getUserId() == userId) {
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                u.setAge(user.getAge());
                u.setProfilePicUrl(user.getProfilePicUrl());

                return u;
            }

        }
        return null;
    }

    public User deleteUser(int userId) {
        User deleteUser = null;
        for(User u:userList ){
            if(u.getUserId()==userId){
                deleteUser = u;
                userList.remove(u);

                return deleteUser;
            }
        }
        return deleteUser;
    }
}
