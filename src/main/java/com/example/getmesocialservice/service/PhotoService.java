package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private  PhotoRepository photoRepository;
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> findPhoto() {
        return photoRepository.findAll();
    }

    public Optional<Photo> findPhotoById(String photoId) {
        return photoRepository.findById(photoId);
    }

    public Photo UpdatePhoto(Photo photo) {
        return photoRepository.save(photo);

    }

    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
}
