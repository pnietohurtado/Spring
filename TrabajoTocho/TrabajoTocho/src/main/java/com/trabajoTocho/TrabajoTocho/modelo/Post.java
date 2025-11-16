package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column
    private int likes;

    @Column
    private int comments;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    private Profile profile;


    public Post(){}
    public Post( int lik, int com, String des, Profile pro){
        this.likes = lik;
        this.comments = com;
        this.description = des;
        this.profile = pro;
    }

    public Long getId_profile() {
        return uuid;
    }

    public void setId_profile(Long id_profile) {
        this.uuid = id_profile;
    }


    public int getLike() {
        return likes;
    }

    public void setLike(int like) {
        this.likes = like;
    }

    public int getComment() {
        return comments;
    }

    public void setComment(int comment) {
        this.comments = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile(){return this.profile; }
    public void setProfile(Profile pro){this.profile = pro; }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return uuid == post.uuid && likes == post.likes && comments == post.comments && Objects.equals(description, post.description) && Objects.equals(profile, post.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, likes, comments, description, profile);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id_profile=" + profile +
                ", like=" + likes +
                ", comment=" + comments +
                ", description='" + description + '\'' +
                '}';
    }
}
