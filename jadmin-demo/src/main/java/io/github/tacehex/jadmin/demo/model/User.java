package io.github.tacehex.jadmin.demo.model;

import io.github.tacehex.jadmin.core.annotation.JAdminEntity;
import io.github.tacehex.jadmin.core.annotation.JAdminField;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@JAdminEntity(displayName = "Пользователи", order = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JAdminField(displayName = "ID", order = 1, showInCreate = false)
    private Long id;

    @JAdminField(displayName = "Имя пользователя", order = 2)
    private String username;

    @JAdminField(displayName = "Email", order = 3)
    private String email;

    @JAdminField(displayName = "Активный", order = 4)
    private Boolean active = true;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
