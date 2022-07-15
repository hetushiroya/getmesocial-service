package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {

    @Autowired
    PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo){
        return photoService.savePhoto(photo);
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
    public Photo UpdatePhoto(@RequestBody Photo photo){
        return photoService.UpdatePhoto(photo);
    }

    @DeleteMapping
    public void deletePhoto(String photoId){
        photoService.deletePhoto(photoId);
    }

}
