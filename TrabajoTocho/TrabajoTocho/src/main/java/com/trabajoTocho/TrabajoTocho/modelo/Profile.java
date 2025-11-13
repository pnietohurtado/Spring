package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.Entity;

@Entity
public class Profile {

    private int id_profile;
    private int id_user;
    private int numberFollowers;
    private String description;

    public Profile(){}
    public Profile(int idp, int idu, int num, String des){
        this.id_profile = idp;
        this.id_user = idu;
        this.numberFollowers = num;
        this.description = des;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
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
    public String toString() {
        return "Profile{" +
                "id_profile=" + id_profile +
                ", id_user=" + id_user +
                ", numberFollowers=" + numberFollowers +
                ", description='" + description + '\'' +
                '}';
    }
}
