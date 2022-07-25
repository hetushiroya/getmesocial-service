package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfo;
import com.example.getmesocialservice.model.FireBaseUser;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.FireBaseService;
import com.example.getmesocialservice.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {

  //  List<User> userList = new ArrayList<>();
    @Autowired
    private UserService userService;

    @Autowired
    private FireBaseService fireBaseService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
      FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
      if(fireBaseUser!=null){
        return userService.saveUser(user);
      }
      else {
        return null;
      }


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
  public User updateUser(@RequestBody @Valid User user, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
    FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
    if (fireBaseUser != null) {
      return userService.updateUser(user);
    }
    return null;
  }


  @DeleteMapping
  public void deleteUser(String albumId, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
    FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
    if (fireBaseUser != null) {
      userService.deleteUser(albumId);
    }
  }
}


