package com.example.getmesocialservice.model;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Album {

    @Id
    private String id;
    private String name;
    private String description;
    private String coverPic;
    private String createdBy;

    private Date dateCreated;

    public Album(String name, String description, String coverPic, String createdBy, Date dateCreated) {
        this.name = name;
        this.description = description;
        this.coverPic = coverPic;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
