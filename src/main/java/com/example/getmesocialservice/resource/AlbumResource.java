package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.FireBaseUser;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.FireBaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    @Autowired
    FireBaseService fireBaseService;

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if (fireBaseUser != null) {
            return albumService.saveAlbum(album);
        }
        return null;
    }

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/findById")
    public Album getAlbumById(@RequestParam(name = "albumId") String  albumId){
        return albumService.getAlbumById(albumId);
    }
    @PutMapping
    public Album updateAlbum(@RequestBody  @Valid Album album, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if(fireBaseUser!=null) {
            return albumService.updateAlbum(album);
        }
        return null;
    }
    @DeleteMapping
    public void deleteAlbum(String albumId, @RequestHeader("idToken") String idToken ) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if(fireBaseUser!=null) {
            albumService.deleteAlbum(albumId);
        }
    }

}
