package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String lastConnection;

    @Column
    private int timeLastConnection;

    public User(){}
    public User(int idu, String u, String p, String con, int last ){
        this.id_user = idu;
        this.username = u;
        this.password = p;
        this.lastConnection = con;
        this.timeLastConnection = last;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
                "id_user=" + id_user +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastConnection='" + lastConnection + '\'' +
                ", timeLastConnection=" + timeLastConnection +
                '}';
    }
}
