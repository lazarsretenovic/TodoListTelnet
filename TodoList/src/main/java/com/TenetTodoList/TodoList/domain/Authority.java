package com.TenetTodoList.TodoList.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private UserTodos userTodos;

    @Column(name = "authority")
    private String authority;

    public Authority() {
    }

    public Authority(Long id, UserTodos userTodos, String authority) {
        this.id = id;
        this.userTodos = userTodos;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTodos getUser() {
        return userTodos;
    }

    public void setUser(UserTodos userTodos) {
        this.userTodos = userTodos;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", user=" + userTodos +
                ", authority='" + authority + '\'' +
                '}';
    }
}
