package com.example.getmesocialservice;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.lazy-initialization=true",
        classes = {UserServiceTest.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Before
    public void saveUser(){
        userService.saveUser(new User( "1", "hetu","Canada",20,"abc.jpg"));

    }

    @Test
    public void getUser(){
       User user = userService.getUserById("1");
        Assert.assertEquals("hetu",user.getName());
    }

    @Test
    public void editUser(){
        User user = userService.getUserById("2");
        user.setName("kiran");
        userService.saveUser(user);
        Assert.assertEquals("kiran","kiran");
    }

    @After
    public void deleteUser(){
        userService.deleteUser("2");
    }
}
