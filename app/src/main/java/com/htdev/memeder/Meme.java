package com.htdev.memeder;

import java.util.ArrayList;
import java.util.List;

public class Meme {
    private Integer ID = 0;
    private String postedBy = "Jeff";
    private String image = "meme.jpg";
    private Integer rating = 0;
    private List<Integer> coments = new ArrayList<>();

    public Meme(Integer ID, String postedBy, String image, Integer rating) {
        this.ID = ID;
        this.postedBy = postedBy;
        this.image = image;
        this.rating = rating;
//        this.coments = coments;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Integer> getComents() {
        return coments;
    }

    public void setComents(List<Integer> coments) {
        this.coments = coments;
    }
}
