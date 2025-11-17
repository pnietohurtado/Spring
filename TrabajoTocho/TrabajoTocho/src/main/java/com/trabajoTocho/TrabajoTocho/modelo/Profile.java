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
@Table(name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    @JsonIgnoreProperties("profile")
//    @JsonBackReference
    private User user;

    @Column
    private int numberFollowers;

    @Column
    private String description;

    /*
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    @JsonManagedReference
    private ArrayList<Post> posts = new ArrayList<>();
    */

    @ManyToMany
    @JoinTable(
            name = "collaborator",
            joinColumns = @JoinColumn(name="profile_uuid"),
            inverseJoinColumns = @JoinColumn(name = "post_uuid")
    )
    @JsonIgnore
    private List<Post> posts;

    public Profile() {}

    public Profile(User user, int num, String des) {
        this.user = user;
        this.numberFollowers = num;
        this.description = des;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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



    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return numberFollowers == profile.numberFollowers && Objects.equals(uuid, profile.uuid) && Objects.equals(user, profile.user) && Objects.equals(description, profile.description) && Objects.equals(posts, profile.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, user, numberFollowers, description, posts);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uuid=" + uuid +
                ", user=" + user +
                ", numberFollowers=" + numberFollowers +
                ", description='" + description + '\'' +
                '}';
    }
}
