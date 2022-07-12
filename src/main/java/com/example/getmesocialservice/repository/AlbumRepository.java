package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList<>();

    public static Album getAlbum() {

        Album album= new Album("het","This is Author's Album","http://abc.jpg");
        return album;
    }

    public Album saveAlbum(Album album) {

        album.setAlbumId(albumList.size()+1);
        albumList.add(album);
        return album;

    }


    public List<Album> getAllAlbums() {
        return albumList;
    }

    public Album updateAlbum(int albumId, Album album) {
        for(Album al:albumList){
            if(al.getAlbumId()==albumId){
                al.setName(album.getName());
                al.setDescription(album.getDescription());
                al.setCoverPic(album.getCoverPic());

                return al;

            }
        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        Album deleteAl = null;
        for (Album al : albumList) {
            if (al.getAlbumId() == albumId) {
                deleteAl = al;
                albumList.remove(al);

                return deleteAl;
            }
        }
        return deleteAl;
    }

    public Album getAlbumById(int albumId) {
        for (Album al:albumList) {
            if (al.getAlbumId() == albumId) {
                return al;
            }
        }
        return null;
    }
}
