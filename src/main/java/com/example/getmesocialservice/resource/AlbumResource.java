package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    @PostMapping
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/findById")
    public Optional<Album> getAlbumById(@RequestParam(name = "albumId") String  albumId){
        return albumService.getAlbumById(albumId);
    }
    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);

    }
    @DeleteMapping
    public void deleteAlbum(String albumId){
         albumService.deleteAlbum(albumId);

    }

}
