package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser(){
        User user = new User("Hetu","Canada",25,"https://helpx.adobe.com/photoshop/using/convert-color-image-black-white.html" );
        return user;
    }
}
