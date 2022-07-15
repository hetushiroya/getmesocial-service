package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {

  //  List<User> userList = new ArrayList<>();
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @PutMapping
  public User updateUser(@RequestBody User user) {
    return userService.updateUser(user);
  }

  @GetMapping("/findById")
  public Optional<User> getUserById(@RequestParam("userId") String userId){
    return userService.getUserById(userId);
  }

  @DeleteMapping
  public void deleteUser(String albumId){
     userService.deleteUser(albumId);
  }

}


