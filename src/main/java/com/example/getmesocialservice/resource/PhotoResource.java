package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfo;
import com.example.getmesocialservice.model.FireBaseUser;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.model.User;
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
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/photoId/{photoId}")
    public Photo findPhotoById(@PathVariable("photoId") String photoId){
        return photoService.findPhotoById(photoId).get();
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

    @GetMapping("/{albumId}")
    public List<Photo> findPhotoByAlbumId(@PathVariable("albumId") String albumId) throws RestrictedInfo {
        return photoService.findPhotoByAlbumId(albumId);
    }

}
