package com.trabajoTocho.TrabajoTocho.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String lastConnection;

    @Column
    private int timeLastConnection;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Profile profile;

    public User(){}
    public User(  String u, String p, String con, int last ){
        this.username = u;
        this.password = p;
        this.lastConnection = con;
        this.timeLastConnection = last;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }

    public int getTimeLastConnection() {
        return timeLastConnection;
    }

    public void setTimeLastConnection(int timeLastConnection) {
        this.timeLastConnection = timeLastConnection;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + uuid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastConnection='" + lastConnection + '\'' +
                ", timeLastConnection=" + timeLastConnection +
                '}';
    }
}
