package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name="Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profile;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @Column
    private int numberFollowers;

    @Column
    private String description;

    @OneToMany(mappedBy = "profile")
    private ArrayList<Post> posts;

    public Profile(){}
    public Profile(int idp, User user, int num, String des){
        this.id_profile = idp;
        this.id_user = user;
        this.numberFollowers = num;
        this.description = des;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public int getNumberFollowers() {
        return numberFollowers;
    }

    public void setNumberFollowers(int numberFollowers) {
        this.numberFollowers = numberFollowers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id_profile == profile.id_profile && numberFollowers == profile.numberFollowers && Objects.equals(id_user, profile.id_user) && Objects.equals(description, profile.description) && Objects.equals(posts, profile.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_profile, id_user, numberFollowers, description, posts);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id_profile=" + id_profile +
                ", id_user=" + id_user +
                ", numberFollowers=" + numberFollowers +
                ", description='" + description + '\'' +
                '}';
    }
}
