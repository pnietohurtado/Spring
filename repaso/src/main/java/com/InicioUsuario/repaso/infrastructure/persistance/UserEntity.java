package com.InicioUsuario.repaso.infrastructure.persistance;

import com.InicioUsuario.repaso.domain.model.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;


    public UserEntity(){}

    public UserEntity(String username, String email, String password, String firstName, String lastName ){
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = Role.CLIENT;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == null) {
            return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
        }
        String authority = this.role.name(); // Siempre va a empezar con "ROLE_" ...
        if (!authority.startsWith("ROLE_")) {
            authority = "ROLE_" + authority;
        }
        return List.of(new SimpleGrantedAuthority(authority));
    }

    public UUID getId(){return this.id;}
    public String getUsername(){return this.username; }
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public String getName(){return this.firstName;}
    public String getLastName(){return this.lastName; }
    public Role getRole(){return this.role; }

    public void setPassword(String password){this.password = password; }
}
