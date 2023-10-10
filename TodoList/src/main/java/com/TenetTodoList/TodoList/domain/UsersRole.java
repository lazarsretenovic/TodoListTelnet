package com.TenetTodoList.TodoList.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UsersRole {
    @Id
    @Column(name = "username",   nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Authority> authorities;

    public UsersRole() {
    }

    public UsersRole(String username, String password, boolean enabled, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UsersRole{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
