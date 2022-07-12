package com.example.getmesocialservice.model;


public class Album {

    private int albumId;
    private String name;
    private String description;
    private String coverPic;

    public Album(String name, String description, String coverPic) {
        this.name = name;
        this.description = description;
        this.coverPic = coverPic;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }
}
