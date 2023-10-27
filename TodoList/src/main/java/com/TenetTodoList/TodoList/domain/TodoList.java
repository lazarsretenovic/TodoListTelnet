package com.TenetTodoList.TodoList.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_list")
public class TodoList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public TodoList() {
    }

    public TodoList(Integer id, String description, Status status, User user) {
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
