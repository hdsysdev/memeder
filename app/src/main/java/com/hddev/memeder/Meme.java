package com.hddev.memeder;

import java.util.ArrayList;
import java.util.List;

public class Meme {
    private Integer ID = 0;
    private String PostedBy = "Jeff";
    private String ImageName = "meme.jpg";
    private Integer rating = 0;
    private String Comments;

    public Meme(Integer ID, String PostedBy, String ImageName, Integer rating) {
        this.ID = ID;
        this.PostedBy = PostedBy;
        this.ImageName = ImageName;
        this.rating = rating;
        this.Comments = Comments;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPostedBy() {
        return PostedBy;
    }

    public void setPostedBy(String PostedBy) {
        this.PostedBy = PostedBy;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }
}
