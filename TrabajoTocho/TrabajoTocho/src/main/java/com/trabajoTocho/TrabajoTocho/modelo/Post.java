package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.Entity;

@Entity
public class Post {
    private int id_profile;
    private int like;
    private int comment;
    private String description;


    public Post(){}
    public Post(int idp, int lik, int com, String des){
        this.id_profile = idp;
        this.like = lik;
        this.comment = com;
        this.description = des;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }


    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id_profile=" + id_profile +
                ", like=" + like +
                ", comment=" + comment +
                ", description='" + description + '\'' +
                '}';
    }
}
