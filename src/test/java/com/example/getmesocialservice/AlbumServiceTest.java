package com.example.getmesocialservice;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.lazy-initialization=true",
        classes = {AlbumService.class})
public class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;

    @Before
    public void saveAlbum(){
        albumService.saveAlbum(new Album("1",
                "hetu","hetu's Album","abc.jpg","hetu",new Date()));

    }
    @Test
    public void getAlbum(){
        Album album = albumService.getAlbumById("1");
        Assert.assertEquals("hetu",album.getName());
    }

    @Test
    public void editAlbum(){
        Album album  = albumService.getAlbumById("2");
        album.setName("kiran");
        albumService.saveAlbum(album);
        Assert.assertEquals("kiran","kiran");
    }
}
