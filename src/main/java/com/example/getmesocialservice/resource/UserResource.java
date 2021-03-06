package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfo;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {

  //  List<User> userList = new ArrayList<>();
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping("/findByName")
  public List<User> getUserByName(@RequestParam("name") String name) throws RestrictedInfo {
      if(name.equalsIgnoreCase("root")){
        throw new RestrictedInfo();
      }
      return userService.getUserByName(name);
  }


  @GetMapping("/findById")
  public User getUserById(@RequestParam("userId") String userId){
    return userService.getUserById(userId);
  }


  @PutMapping
  public User updateUser(@RequestBody @Valid User user) {
    return userService.updateUser(user);
  }


  @DeleteMapping
  public void deleteUser(String albumId){
     userService.deleteUser(albumId);
  }

}


