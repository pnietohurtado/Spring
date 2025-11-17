package com.trabajoTocho.TrabajoTocho.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    /*
    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    @JsonBackReference
    private Profile profile;
    */


    @ManyToMany(mappedBy = "posts")
    @JsonIgnore
    private List<Profile> profiles;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnore
    //@JsonManagedReference
    private List<Response> responses = new ArrayList<>();

    public Post(){}
    public Post( int lik, int com, String des){
        this.likes = lik;
        this.comments = com;
        this.description = des;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return likes == post.likes && comments == post.comments && Objects.equals(uuid, post.uuid) && Objects.equals(description, post.description) && Objects.equals(profiles, post.profiles) && Objects.equals(responses, post.responses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, likes, comments, description, profiles, responses);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id_profile=" + profiles +
                ", like=" + likes +
                ", comment=" + comments +
                ", description='" + description + '\'' +
                '}';
    }
}
