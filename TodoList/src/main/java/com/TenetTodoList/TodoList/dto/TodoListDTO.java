package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.User;

public class TodoListDTO {
    private int id;
    private String description;
    private String status;

    private User user;

    public TodoListDTO() {
    }

    public TodoListDTO(int id, String description, String status, User user) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
