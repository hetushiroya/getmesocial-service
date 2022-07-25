package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.FireBaseUser;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.FireBaseService;
import com.example.getmesocialservice.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {

    @Autowired
    PhotoService photoService;

    @Autowired
    FireBaseService fireBaseService;

    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo , @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if (fireBaseUser != null) {
            return photoService.savePhoto(photo);
        }
        return null;
    }



    @GetMapping
    public List<Photo> findPhotos(){
        return photoService.findPhoto();
    }

    @GetMapping("/findById")
    public Optional<Photo> findPhotoById(@RequestParam String photoId){
        return photoService.findPhotoById(photoId);
    }

    @PutMapping
    public Photo UpdatePhoto(@RequestBody @Valid Photo photo, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if (fireBaseUser != null) {
            return photoService.UpdatePhoto(photo);
        }
        return null;
    }


    @DeleteMapping
    public void deletePhoto(String photoId, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if (fireBaseUser != null) {
            photoService.deletePhoto(photoId);
        }
    }

}
